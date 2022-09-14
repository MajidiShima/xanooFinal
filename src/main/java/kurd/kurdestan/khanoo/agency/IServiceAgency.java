package kurd.kurdestan.khanoo.agency;


import kurd.kurdestan.khanoo.house.House;

import java.util.List;

public interface IServiceAgency {

    Agency save(Agency agency);
    Agency update(Agency agency);
    void delete(Long id);
    List<Agency> getAll();
    Agency getById(Long id);
    List<House>findAllByAgency_id(Long agencyId);

}
