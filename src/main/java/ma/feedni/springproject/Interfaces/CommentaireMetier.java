package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Commentaire;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface CommentaireMetier {

    void addCommentaire(Commentaire commentaire);
    void deleteCommentaire(Commentaire commentaire);
    void updateCommentaire(Commentaire commentaire);

    Optional<Commentaire> findById(Long id);
    List<Commentaire> findByPost(Post post);
    List<Commentaire> findByUser(Utilisateur utilisateur);
    List<Commentaire> findAll();
}
