package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.RoleMetier;
import ma.feedni.springproject.Model.Role;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements RoleMetier {

    @Autowired
    private RoleRepository repository;

    @Override
    public void addRole(Role role) {
        repository.save(role);
    }

    @Override
    public void updateRole(Role role) {
        Role roleToUpdate = repository.getOne(role.getId());
        roleToUpdate.setName(role.getName());
        repository.save(roleToUpdate);
    }

    @Override
    public void deleteRole(Role role) {
        repository.delete(role);
    }

    @Override
    public Optional<Role> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Role> findByRole(String role) {
        return repository.findByName(role);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }
}
