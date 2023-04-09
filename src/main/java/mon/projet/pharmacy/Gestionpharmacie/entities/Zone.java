package mon.projet.pharmacy.Gestionpharmacie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@JsonIgnoreProperties("ph")
@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "zone")
    private List<Pharmacie> ph;

    private String nom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville_id")
    private Ville ville;


    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Pharmacie> getPh() {
        return ph;
    }

    public void setPh(List<Pharmacie> ph) {
        this.ph = ph;
    }


}
