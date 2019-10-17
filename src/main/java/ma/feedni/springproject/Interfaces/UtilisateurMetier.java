package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface UtilisateurMetier {

    void addUser(Utilisateur user);
    boolean updateUser(Utilisateur user);
    void deleteUser(Utilisateur user);

    Optional<Utilisateur> findUserByEmail(String email);
    Optional<Utilisateur> findById(Long idUser);
    List<Utilisateur> findByType(String typeUser);
    List<Utilisateur> findAll();

}
