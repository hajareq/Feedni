package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.LocalisationMetier;
import ma.feedni.springproject.Model.Localisation;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Repositories.LocalisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalisationService implements LocalisationMetier {

    @Autowired
    private LocalisationRepository repository;

    @Override
    public void addLocalisation(Localisation localisation) {
        repository.save(localisation);
    }

    @Override
    public void updateLocalisation(Localisation localisation) {
        Localisation localisationToUpdate = repository.getOne(localisation.getIdLocalisation());
        localisationToUpdate.setLatitude(localisation.getLatitude());
        localisationToUpdate.setLongitude(localisation.getLongitude());
        localisationToUpdate.setVille(localisation.getVille());
        repository.save(localisationToUpdate);
    }

    @Override
    public void deleteLocalisation(Localisation localisation) {
        repository.delete(localisation);
    }

    @Override
    public Optional<Localisation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Localisation> findByPost(Post post) {
        return repository.findByPost(post);
    }

    @Override
    public List<Localisation> findAll() {
        return repository.findAll();
    }
}
