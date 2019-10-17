package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Commentaire;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    @Query("select c from Commentaire c where c.post = ?1")
    List<Commentaire> findByPost(Post post);

    @Query("select c from Commentaire c where c.utilisateur = ?1")
    List<Commentaire> findByUtilisateur(Utilisateur utilisateur);
}
