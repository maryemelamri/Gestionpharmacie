package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ville {
    @Id
    private int id_ville;
    private String nom_ville;

    public Ville() {

    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getNom_ville() {
        return nom_ville;
    }

    public void setNom_ville(String nom_ville) {
        this.nom_ville = nom_ville;
    }
}
