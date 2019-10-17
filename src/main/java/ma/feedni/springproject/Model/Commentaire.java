package ma.feedni.springproject.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Commentaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommentaire;
    private String commentaire;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateCommentaire;

    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Post post;

    public Commentaire() {
    }

    public Commentaire(String commentaire, Date dateCommentaire) {
        this.commentaire = commentaire;
        this.dateCommentaire = dateCommentaire;
    }

    public Long getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(Long idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(Date dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
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
