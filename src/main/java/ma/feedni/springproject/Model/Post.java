package ma.feedni.springproject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String titre;
    private String description;
    private Date dateCreation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Collection<Commentaire> listCommentaires;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private Collection<Likke> listLikkes;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "post")
    private Localisation localisation;

    @ManyToOne
    private Type type;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post", fetch = FetchType.LAZY)
    private Collection<Image> listImages;

    @JsonBackReference
    @ManyToOne
    private Utilisateur utilisateur;

    public Post() {
    }

    public Post(String titre, String description, Date dateCreation) {
        this.titre = titre;
        this.description = description;
        this.dateCreation = dateCreation;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<Commentaire> getListCommentaires() {
        return listCommentaires;
    }

    public void setListCommentaires(Collection<Commentaire> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    public Collection<Likke> getListLikkes() {
        return listLikkes;
    }

    public void setListLikkes(Collection<Likke> listLikkes) {
        this.listLikkes = listLikkes;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Collection<Image> getListImages() {
        return listImages;
    }

    public void setListImages(Collection<Image> listImages) {
        this.listImages = listImages;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
