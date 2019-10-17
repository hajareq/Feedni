package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Role;
import ma.feedni.springproject.Model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface RoleMetier {

    void addRole(Role role);
    void updateRole(Role role);
    void deleteRole(Role role);

    Optional<Role> findById(Long id);
    Optional<Role> findByRole(String role);
    List<Role> findAll();
}
