package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Type;

import java.util.List;
import java.util.Optional;

public interface PostMetier {

    void addPost(Post post);
    void updatePost(Post post);
    void deletePost(Post post);

    Optional<Post> findById(Long id);
    List<Post> findAll();
    List<Post> findByLocalisation(Localisation localisation);
    List<Post> findByType(Type type);
}
