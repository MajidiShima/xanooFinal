package kurd.kurdestan.khanoo.city;


import kurd.kurdestan.khanoo.agency.IAgencyMapper;
import kurd.kurdestan.khanoo.house.House;
import kurd.kurdestan.khanoo.house.HouseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Data
public class CityController {
    private CityMapper mapper;
    private final ICityService service;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        CityDTO cityDTO1 = mapper.toCityDTO(service.update(city));
        return ResponseEntity.ok(cityDTO1);
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<CityDTO> getById(@PathVariable Long id) {
        City city = service.getById(id);
        CityDTO cityDTO = mapper.toCityDTO(city);
        return ResponseEntity.ok(cityDTO);
    }

    @GetMapping("/v1/{name}")
    public ResponseEntity<CityDTO> getByName(@PathVariable String name) {
        City city1 = service.getByName(name);
        CityDTO cityDTO1 = mapper.toCityDTO(city1);
        return ResponseEntity.ok(cityDTO1);

    }

    @GetMapping("/v1/All/")
    public ResponseEntity<CityDTO> getAll() {
        List<City> listCity = service.getAll();
        List<CityDTO> list  = mapper.toListDTO(listCity);

       // ResponseEntity.ok(list);
       return null;
    }

}
