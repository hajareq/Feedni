package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalisationRepository extends JpaRepository<Localisation, Long> {

    @Query("select l from Localisation l where l.post = ?1")
    Optional<Localisation> findByPost(Post post);
}
