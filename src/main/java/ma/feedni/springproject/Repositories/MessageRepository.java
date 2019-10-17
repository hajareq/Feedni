package ma.feedni.springproject.Repositories;

import ma.feedni.springproject.Model.Message;
import ma.feedni.springproject.Model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query("select m from Message m where m.utilisateur = ?1")
    List<Message> findByUtilisateur(Utilisateur utilisateur);
}
