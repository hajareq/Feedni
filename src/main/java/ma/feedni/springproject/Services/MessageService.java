package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.MessageMetier;
import ma.feedni.springproject.Model.Message;
import ma.feedni.springproject.Model.Utilisateur;
import ma.feedni.springproject.Repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService implements MessageMetier {

    @Autowired
    private MessageRepository repository;

    @Override
    public void addMessage(Message message) {
        repository.save(message);
    }

    @Override
    public void updateMessage(Message message) {
        Message messageToUpdate = repository.getOne(message.getIdMessage());
        messageToUpdate.setMessage(message.getMessage());
        messageToUpdate.setLu(message.isLu());
        repository.save(messageToUpdate);
    }

    @Override
    public void deleteMessage(Message message) {
        repository.delete(message);
    }

    @Override
    public Optional<Message> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Message> findByUser(Utilisateur utilisateur) {
        return repository.findByUtilisateur(utilisateur);
    }

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }
}
