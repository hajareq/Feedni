package ma.feedni.springproject.Model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Localisation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocalisation;
    private Double longitude;
    private Double latitude;
    private String ville;

    @OneToOne
    private Post post;

    public Localisation() {
    }

    public Localisation(Double longitude, Double latitude, String ville) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.ville = ville;
    }

    public Long getIdLocalisation() {
        return idLocalisation;
    }

    public void setIdLocalisation(Long idLocalisation) {
        this.idLocalisation = idLocalisation;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
