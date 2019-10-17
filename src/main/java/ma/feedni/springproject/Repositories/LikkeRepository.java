package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Likke;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikkeRepository extends JpaRepository<Likke, Long> {

    @Query("select l from Likke l where l.post = ?1")
    List<Likke> findByPost(Post post);

    @Query("select l from Likke l where l.utilisateur = ?1")
    List<Likke> findByUtilisateur(Utilisateur utilisateur);
}
