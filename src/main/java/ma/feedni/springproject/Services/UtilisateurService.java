package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.UtilisateurMetier;
import ma.feedni.springproject.Model.Admin;
import ma.feedni.springproject.Model.Moderator;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UtilisateurService implements UserDetailsService, UtilisateurMetier {

    @Autowired
    private UtilisateurRepository repository;

    @Autowired
    private RoleService service;

    private PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public void addUser(Utilisateur user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(user instanceof Admin)
            user.setRole(service.findByRole("admin").get());
        else if(user instanceof Moderator)
            user.setRole(service.findByRole("moderator").get());
        else
            user.setRole(service.findByRole("client").get());
        repository.save(user);
    }

    @Override
    public boolean updateUser(Utilisateur user) {
        Utilisateur utilisateur = repository.getOne(user.getIdUtilisateur());
        utilisateur.setNom(user.getNom());
        utilisateur.setPrenom(user.getPrenom());
        utilisateur.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(utilisateur)!=null;
    }

    @Override
    public void deleteUser(Utilisateur user) {
        repository.delete(user);
    }

    @Override
    public Optional<Utilisateur> findUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<Utilisateur> findById(Long idUser) {
        return repository.findById(idUser);
    }

    @Override
    public List<Utilisateur> findByType(String typeUser) {
        return repository.findByTypeModerator(typeUser);
    }

    @Override
    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Objects.requireNonNull(email);
        Utilisateur user = repository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }
}
