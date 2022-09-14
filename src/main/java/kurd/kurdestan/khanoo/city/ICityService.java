package kurd.kurdestan.khanoo.city;


import java.util.List;

public interface ICityService {

City save(City city);
City update(City city);
City getById(Long id);
City getByName(String name);
List<City> getAll();

}
