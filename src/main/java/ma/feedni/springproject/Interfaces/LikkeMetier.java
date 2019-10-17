package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Likke;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface LikkeMetier {

    void addLike(Likke likke);
    void updateLike(Likke likke);
    void deleteLike(Likke likke);

    Optional<Likke> findById(Long id);
    List<Likke> findByPost(Post post);
    List<Likke> findByUser(Utilisateur utilisateur);
    int numberLikeByPost(Post post);
    int numberLikeByUser(Utilisateur utilisateur);
    List<Likke> findAll();
}
