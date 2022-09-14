package kurd.kurdestan.khanoo.city;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CityServiceImp implements ICityService {

    private final CityRepository repository;

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City update(City city) {
        City lastCity = getById(city.getId());
        lastCity.setId(lastCity.getId());
        lastCity.setName(lastCity.getName());
        return repository.save(lastCity);
    }

    @Override
    public City getById(Long id) {
        Optional<City> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Not Found City");
        }
        return optional.get();
    }

    @Override
    public City getByName(String name) {
        return (City) repository.findAllByName(name);
    }

    @Override
    public List<City> getAll() {
        List<City> list = (List<City>) repository.findAll();
        return list;
    }
}
