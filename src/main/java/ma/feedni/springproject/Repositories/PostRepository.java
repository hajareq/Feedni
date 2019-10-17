package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p where p.localisation = ?1")
    List<Post> findByLocalisation(Localisation localisation);

    @Query("select p from Post p where p.type = ?1")
    List<Post> findByType (Type type);
}
