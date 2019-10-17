package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.LikkeMetier;
import ma.feedni.springproject.Model.Likke;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Repositories.LikkeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikkeService implements LikkeMetier {

    @Autowired
    private LikkeRepository repository;

    @Override
    public void addLike(Likke likke) {
        repository.save(likke);
    }

    @Override
    public void updateLike(Likke likke) {
        Likke likeToUpdate = repository.getOne(likke.getIdLike());
        /////////////////////????
        repository.save(likeToUpdate);
    }

    @Override
    public void deleteLike(Likke likke) {
        repository.delete(likke);
    }

    @Override
    public Optional<Likke> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Likke> findByPost(Post post) {
        return repository.findByPost(post);
    }

    @Override
    public List<Likke> findByUser(Utilisateur utilisateur) {
        return repository.findByUtilisateur(utilisateur);
    }

    @Override
    public int numberLikeByPost(Post post) {
        return findByPost(post).size();
    }

    @Override
    public int numberLikeByUser(Utilisateur utilisateur) {
        return findByUser(utilisateur).size();
    }

    @Override
    public List<Likke> findAll() {
        return repository.findAll();
    }
}
