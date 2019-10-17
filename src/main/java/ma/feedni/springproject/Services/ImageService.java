package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.ImageMetier;
import ma.feedni.springproject.Model.Image;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService implements ImageMetier {

    @Autowired
    private ImageRepository repository;

    @Override
    public void addImage(Image image) {
        repository.save(image);
    }

    @Override
    public void updateImage(Image image) {
        Image imageToUpdate = repository.getOne(image.getIdImage());
        imageToUpdate.setNom(image.getNom());
        //////////////////////////////////////???????
        repository.save(imageToUpdate);
    }

    @Override
    public void deleteImage(Image image) {
        repository.delete(image);
    }

    @Override
    public Optional<Image> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Image> findByPost(Post post) {
        return repository.findByPost(post);
    }

    @Override
    public List<Image> findAll() {
        return repository.findAll();
    }
}
