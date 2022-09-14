package kurd.kurdestan.khanoo.image;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    Image toImage(ImageDTO imageDTO);
    ImageDTO toImageDTO(Image image);
    List<Image> toListImage(List<ImageDTO> imageDTOList);
    List<ImageDTO> toListImageDTO(List<Image> imageList);



}
