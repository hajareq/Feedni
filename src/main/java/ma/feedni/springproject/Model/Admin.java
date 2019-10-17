package ma.feedni.springproject.Model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="AD")
public class Admin extends Utilisateur implements Serializable {

    public Admin() {
    }

    public Admin(String nom, String prenom, String email, String password) {
        super(nom, prenom, email, password);
    }
}
