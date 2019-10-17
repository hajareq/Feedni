package ma.feedni.springproject.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Likke implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLike;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Post post;

    public Likke() {
    }

    public Likke(Utilisateur utilisateur, Post post) {
        this.utilisateur = utilisateur;
        this.post = post;
    }

    public Long getIdLike() {
        return idLike;
    }

    public void setIdLike(Long idLike) {
        this.idLike = idLike;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
