package ma.feedni.springproject.Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="CL")
public class Client extends Utilisateur implements Serializable {

    public Client() {
    }

    public Client(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }
}
