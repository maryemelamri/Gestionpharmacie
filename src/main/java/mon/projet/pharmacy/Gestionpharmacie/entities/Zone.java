package mon.projet.pharmacy.Gestionpharmacie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "zone")
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "zone")
    @JsonIgnore
    private List<Pharmacie> pharmacie;


    private String nom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ville")
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
        return pharmacie;
    }

    public void setPh(List<Pharmacie> ph) {
        this.pharmacie = ph;
    }


}
