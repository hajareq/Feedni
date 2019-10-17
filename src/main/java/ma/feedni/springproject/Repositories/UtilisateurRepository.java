package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    @Query(" select u from Utilisateur u where u.email = ?1")
    Optional<Utilisateur> findByEmail(String email);

    @Query("select u from Utilisateur u where u.typeModerator = ?1")
    List<Utilisateur> findByTypeModerator (String type);
}
