package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Role;
import ma.feedni.springproject.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    @Query("select r from Role r where r.name = ?1")
    Optional<Role> findByName(String role);

}
