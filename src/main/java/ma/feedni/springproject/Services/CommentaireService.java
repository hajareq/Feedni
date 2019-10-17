package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.CommentaireMetier;
import ma.feedni.springproject.Model.Commentaire;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Repositories.CommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService implements CommentaireMetier {

    @Autowired
    private CommentaireRepository repository;

    @Override
    public void addCommentaire(Commentaire commentaire) {
        repository.save(commentaire);
    }

    @Override
    public void deleteCommentaire(Commentaire commentaire) {
        repository.delete(commentaire);
    }

    @Override
    public void updateCommentaire(Commentaire commentaire) {
        Commentaire commentToUpdate = repository.getOne(commentaire.getIdCommentaire());
        commentToUpdate.setCommentaire(commentaire.getCommentaire());
        repository.save(commentToUpdate);
    }

    @Override
    public Optional<Commentaire> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Commentaire> findByPost(Post post) {
        return repository.findByPost(post);
    }

    @Override
    public List<Commentaire> findByUser(Utilisateur utilisateur) {
        return repository.findByUtilisateur(utilisateur);
    }

    @Override
    public List<Commentaire> findAll() {
        return repository.findAll();
    }
}
