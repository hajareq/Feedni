package ma.feedni.springproject.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue(value="MO")
public class Moderator extends Utilisateur implements Serializable {

    private String typeModerator;

    public Moderator() {
    }

    public Moderator(String nom, String prenom, String email, String password, String typeModerator) {
        super(nom, prenom, email, password);
        this.typeModerator = typeModerator;
    }

    public Moderator(String typeModerator) {
        this.typeModerator = typeModerator;
    }

    public String getTypeModerator() {
        return typeModerator;
    }

    public void setTypeModerator(String typeModerator) {
        this.typeModerator = typeModerator;
    }
}
