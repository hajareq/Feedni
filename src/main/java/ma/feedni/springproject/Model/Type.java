package ma.feedni.springproject.Model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idType;
    private String intitule;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "type")
    private Collection<Post> listPosts;

    public Type() {
    }

    public Type(String intitule) {
        this.intitule = intitule;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Collection<Post> getListPosts() {
        return listPosts;
    }

    public void setListPosts(Collection<Post> listPosts) {
        this.listPosts = listPosts;
    }
}
