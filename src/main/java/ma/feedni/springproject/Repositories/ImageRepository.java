package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Image;
import ma.feedni.springproject.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    @Query("select i from Image i where i.post = ?1")
    List<Image> findByPost(Post post);
}
