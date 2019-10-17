package ma.feedni.springproject.Interfaces;

import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Type;

import java.util.List;
import java.util.Optional;

public interface TypeMetier {

    void addType(Type type);
    void updateType(Type type);
    void deleteType(Type type);

    Optional<Type> findById(int id);
    List<Type> findAll();
}
