package kurd.kurdestan.khanoo.image;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@Data

public class ImageServiceImp implements IImageService{

    private final ImageRepository repository;


    @Override
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public void delete(Long id) {
        getById(id);
        repository.deleteById(id);
    }

    @Override
    public Image update(Image image) {

        Image lastSavedImage = getById(image.getId());
        lastSavedImage.setName(image.getName());
        lastSavedImage.setHouse(image.getHouse());
        return repository.save(lastSavedImage);
    }

    @Override
    public Image getById(Long id) {
        Optional<Image> optional=repository.findById(id);
        if (!optional.isPresent()){
            throw new NotFoundException("Image Not Found");
        }

        return optional.get();
    }

    @Override
    public Image getByName(String name) {
 Optional<Image> optionalImage=repository.findByName(name);
 if (!optionalImage.isPresent()){
     throw new NotFoundException("Name Not Found");
 }
        return optionalImage.get();
    }

    @Override
    public List<Image> getAllByHouseId(Long id) {

        return (List<Image>) repository.findAllByHouse_Id(id);
    }

    @Override
    public List<Image> getAll() {
        return (List<Image>) repository.findAll();
    }
}
