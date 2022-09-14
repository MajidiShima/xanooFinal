package kurd.kurdestan.khanoo.house;


import kurd.kurdestan.khanoo.commen.PagingData;
import kurd.kurdestan.khanoo.commen.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/House/")
@AllArgsConstructor
public class HouseController {

    private final IHouseService service;
    private IHouseMapper mapper;

    @PostMapping("/v1")
    public ResponseEntity save(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        service.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/v1/{id}")
    public ResponseEntity<HouseDTO> getById(@PathVariable Long id) {
        House house = service.getById(id);
        HouseDTO houseDTO = mapper.toHouseDTO(house);
        return ResponseEntity.ok(houseDTO);
    }

    @PutMapping
    public ResponseEntity<HouseDTO> update(@RequestBody HouseDTO houseDTO){
        House house=mapper.toHouse(houseDTO);
       HouseDTO houseDTO1= mapper.toHouseDTO(service.update(house));
        return ResponseEntity.ok(houseDTO1);
    }



    @DeleteMapping("/v1/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/v1/agency/{agencyId}/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPagingByAgency(@PathVariable Long agencyId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<House> housePage = service.pagingByAgencyId(agencyId, page, size);
        return getPagingDataResponseEntity(page, housePage);
    }

    @GetMapping("/v1/region/{regionId}/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPagingByRegion(@PathVariable Long regionId, @PathVariable Integer page, @PathVariable Integer size) {
        Page<House> housePage = service.pagingByRegionId(regionId, page, size);
        return getPagingDataResponseEntity(page, housePage);
    }

    @GetMapping("/v1/paging/{page}/{size}")
    public ResponseEntity<PagingData<HouseDTO>> getAllPaging(@PathVariable Integer page, @PathVariable Integer size) {
        Page<House> housePage = service.paging(page, size);
        return getPagingDataResponseEntity(page, housePage);
    }

    @PostMapping("/v1/search")
    public ResponseEntity<List<HouseDTO>> search(@RequestBody List<SearchCriteria> searchCriteria) {
        List<House> houseList = service.search(searchCriteria);
        List<HouseDTO> houseDTOS = mapper.toHouseTDOs(houseList);
        return ResponseEntity.ok(houseDTOS);
    }

    private ResponseEntity<PagingData<HouseDTO>> getPagingDataResponseEntity(@PathVariable Integer page, Page<House> housePage) {
        int totalPage = housePage.getTotalPages();
        List<House> data = housePage.getContent();
        List<HouseDTO> houseDTOS = mapper.toHouseTDOs(data);
        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, houseDTOS);
        return ResponseEntity.ok(pagingData);
    }



}
