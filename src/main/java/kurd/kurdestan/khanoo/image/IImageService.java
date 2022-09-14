package kurd.kurdestan.khanoo.image;

import java.util.List;

public interface IImageService {

    Image save(Image image);
    void delete(Long id);
    Image update(Image image);
    Image getById(Long id);
    Image getByName(String name);
    List<Image> getAllByHouseId(Long id);
    List<Image> getAll();
}
