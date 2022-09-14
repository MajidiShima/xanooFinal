package kurd.kurdestan.khanoo.agency;


import kurd.kurdestan.khanoo.house.House;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class AgencyService implements IServiceAgency {
    private final AgencyRepository repository;

    @Override
    public Agency save(Agency agency) {
        return repository.save(agency);
    }

    @Override
    public Agency update(Agency agency) {

        Agency lastAgency = getById(agency.getId());
        lastAgency.setLocation(agency.getLocation());
        lastAgency.setAddress(agency.getAddress());
        lastAgency.setTitle(agency.getTitle());
        lastAgency.setPhoneOrEmail(agency.getPhoneOrEmail());

        return repository.save(agency);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public List<Agency> getAll() {

        List<Agency> list = (List<Agency>) repository.findAll();
        return list;
    }

    @Override
    public Agency getById(Long id) {
        Optional<Agency> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException("Agency Not Found");
        }
        return optional.get();
    }

    @Override
    public List<House> findAllByAgency_id(Long agencyId) {
        //this is have new problem with house and agency

        return null;
    }
}
