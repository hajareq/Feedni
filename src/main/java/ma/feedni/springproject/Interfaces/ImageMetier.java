package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Image;
import ma.feedni.springproject.Model.Post;

import java.util.List;
import java.util.Optional;

public interface ImageMetier {

    void addImage(Image image);
    void updateImage(Image image);
    void deleteImage(Image image);

    Optional<Image> findById(Long id);
    List<Image> findByPost(Post post);
    List<Image> findAll();
}
