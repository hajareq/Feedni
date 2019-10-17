package ma.feedni.springproject.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = { "email" }))
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_USER",discriminatorType=DiscriminatorType.STRING,length=2)
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long idUtilisateur;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastLogin;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Collection<Message> listMessages;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Collection<Post> listPosts;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Collection<Commentaire> listCommentaires;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private Collection<Likke> listLikkes;

    @ManyToOne
    private Role role;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Collection<Message> getListMessages() {
        return listMessages;
    }

    public void setListMessages(Collection<Message> listMessages) {
        this.listMessages = listMessages;
    }

    public Collection<Post> getListPosts() {
        return listPosts;
    }

    public void setListPosts(Collection<Post> listPosts) {
        this.listPosts = listPosts;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
