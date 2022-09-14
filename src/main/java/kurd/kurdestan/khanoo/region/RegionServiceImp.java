package kurd.kurdestan.khanoo.region;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.envers.Audited;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@Data

public class RegionServiceImp implements IRegionService {

    private final RegionRepository repository;


    @Override
    public Region save(Region region) {

        return repository.save(region);
    }

    @Override
    public Region update(Region region) {
        Region lastRegion=getById(region.getId());
        lastRegion.setName(region.getName());
        lastRegion.setCity(region.getCity());


        return repository.save(lastRegion);
    }

    @Override
    public Region getById(Long id) {

        Optional<Region> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("Region Not Found");
        }

        return optional.get();
    }

    @Override
    public List<Region> getAll() {
        return (List<Region>) repository.findAll();
    }

    @Override
    public Region getByName(String name) {
        Optional<Region> regionOptional= Optional.ofNullable(repository.findByName(name));

        if (!regionOptional.isPresent()) {
            throw new NotFoundException("Region Not Found!");
        }
        return regionOptional.get();
    }

    @Override
    public List<Region> getAllByHouse_Id(Long houseId) {
        return repository.findAllByHouse_Id(houseId);
    }

    @Override
    public List<Region> getAllByCity_Id(Long cityId) {
        return repository.findAllByCity_Id(cityId);
    }
}
