package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {

}
