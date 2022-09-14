package kurd.kurdestan.khanoo.region;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/region/")
public class RegionController {
    private final IRegionService service;
    private RegionMapper mapper;


    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        service.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/v1")
    public ResponseEntity update(@RequestBody RegionDTO regionDTO){
        Region region=mapper.toRegion(regionDTO);
        service.update(region);
        return ResponseEntity.ok().build();

    }


    @GetMapping("/v1/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Region region=service.getById(id);
        RegionDTO regionDTO=mapper.toRegionDTO(region);
        return  ResponseEntity.ok(regionDTO);
    }

    @GetMapping("/v1/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        Region region=service.getByName(name);
        RegionDTO regionDTO=mapper.toRegionDTO(region);
        return ResponseEntity.ok(regionDTO);
    }
    @GetMapping("/v1/house/{houseId}")
    public ResponseEntity<List<RegionDTO>> getAllByHouse_Id(@PathVariable Long houseId){
        List<Region> regionList=service.getAllByHouse_Id(houseId);
        List<RegionDTO> regionDTOS=mapper.toRegionDTOs(regionList);
        return  ResponseEntity.ok(regionDTOS);
    }

    @GetMapping("/v1/city/{cityId}")
    public ResponseEntity<List<RegionDTO>> getAllByCity_Id(@PathVariable Long cityId) {

        List<Region> regionList = service.getAllByHouse_Id(cityId);
        List<RegionDTO> regionDTOS = mapper.toRegionDTOs(regionList);
        return ResponseEntity.ok(regionDTOS);
    }

    @GetMapping("/v1/getAll")
    public ResponseEntity<List<RegionDTO>> getAll() {
        List<Region> regionList = service.getAll();
        List<RegionDTO> regionDTOS = mapper.toRegionDTOs(regionList);
        return ResponseEntity.ok(regionDTOS);
    }









}
