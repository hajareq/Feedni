package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;

import java.util.List;
import java.util.Optional;

public interface LocalisationMetier {

    void addLocalisation(Localisation localisation);
    void updateLocalisation(Localisation localisation);
    void deleteLocalisation(Localisation localisation);

    Optional<Localisation> findById(Long id);
    Optional<Localisation> findByPost(Post post);
    List<Localisation> findAll();
}
