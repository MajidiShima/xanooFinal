package kurd.kurdestan.khanoo.house;

import kurd.kurdestan.khanoo.commen.SearchCriteria;
import kurd.kurdestan.khanoo.commen.SearchSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class HouseService implements IHouseService {

    private final HouseRepository repository;


    @Override
    public House save(House house) {
        return repository.save(house);
    }

    @Override
    public House update(House house) {

        House lastHouse = getById(house.getId());

        lastHouse.setType(house.getType());
        lastHouse.setAnbari(house.getAnbari());
        lastHouse.setAsansor(house.getAsansor());
        lastHouse.setMetrazh(house.getMetrazh());
        lastHouse.setBalcon(house.getBalcon());
        lastHouse.setParking(house.getParking());
        lastHouse.setImageList(house.getImageList());
        lastHouse.setTypeOfHouse(house.getTypeOfHouse());
        lastHouse.setTabaghe(house.getTabaghe());
        lastHouse.setRoom(house.getRoom());
        lastHouse.setShomaliJnobi(house.getShomaliJnobi());
        lastHouse.setYear(house.getYear());
        lastHouse.setVahed(house.getVahed());
        lastHouse.setLocation(house.getLocation());
        return repository.save(lastHouse);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<House> getAll() {
        List<House> list = (List<House>) repository.findAll();
        return list;

    }

    @Override
    public House getById(Long id) {
        Optional<House> optionalHouse = repository.findById(id);
        if (!optionalHouse.isPresent()) {
            throw new NotFoundException("Not Any House");
        }
        return optionalHouse.get();
    }

    @Override
    public Page<House> paging(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size, Sort.by("id").descending()));
    }

    @Override
    public Page<House> pagingByAgencyId(Long agencyId, Integer page, Integer size) {
        return repository.findAllByAgency_Id(agencyId, PageRequest.of(page, size, Sort.by("id").descending()));
    }
    @Override
    public Page<House> pagingByRegionId(Long regionId, Integer page, Integer size) {
        return repository.findAllByRegion_Id(regionId, PageRequest.of(page, size, Sort.by("id").descending()));
    }
    @Override
    public List<House> search(List<SearchCriteria> searchCriteria) {
        SearchSpecification<House> HouseSpecification = new SearchSpecification<>();
        searchCriteria.forEach(criteria -> HouseSpecification.add(criteria));
        return repository.findAll(HouseSpecification);
    }

}
