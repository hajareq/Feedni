package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.PostMetier;
import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Type;
import ma.feedni.springproject.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService implements PostMetier {

    @Autowired
    private PostRepository repository;

    @Override
    public void addPost(Post post) {
        repository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        Post postToUpdate = repository.getOne(post.getIdPost());
        postToUpdate.setTitre(post.getTitre());
        postToUpdate.setDescription(post.getDescription());
        postToUpdate.setType(post.getType());
        postToUpdate.setListImages(post.getListImages());

        repository.save(postToUpdate);
    }

    @Override
    public void deletePost(Post post) {
        repository.delete(post);
    }

    @Override
    public Optional<Post> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Post> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> findByLocalisation(Localisation localisation) {
        return repository.findByLocalisation(localisation);
    }

    @Override
    public List<Post> findByType(Type type) {
        return repository.findByType(type);
    }
}
