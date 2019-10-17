package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Message;
import ma.feedni.springproject.Model.Utilisateur;

import java.util.List;
import java.util.Optional;

public interface MessageMetier {

    void addMessage(Message message);
    void updateMessage(Message message);
    void deleteMessage(Message message);

    Optional<Message> findById(Long id);
    List<Message> findByUser(Utilisateur utilisateur);
    List<Message> findAll();
}
