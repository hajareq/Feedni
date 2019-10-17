package ma.feedni.springproject.Services;

import ma.feedni.springproject.Interfaces.TypeMetier;
import ma.feedni.springproject.Model.Post;
import ma.feedni.springproject.Model.Type;
import ma.feedni.springproject.Repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService implements TypeMetier {

    @Autowired
    private TypeRepository repository;

    @Override
    public void addType(Type type) {
        repository.save(type);
    }

    @Override
    public void updateType(Type type) {
        Type typeToUpdate = repository.getOne(type.getIdType());
        typeToUpdate.setIntitule(type.getIntitule());

        repository.save(typeToUpdate);
    }

    @Override
    public void deleteType(Type type) {
        repository.delete(type);
    }

    @Override
    public Optional<Type> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Type> findAll() {
        return repository.findAll();
    }
}
