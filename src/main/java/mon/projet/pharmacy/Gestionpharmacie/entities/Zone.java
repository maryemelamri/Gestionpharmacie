package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.OneToMany;

import java.util.List;

public class Zone {
    public int getId_zone() {
        return id_zone;
    }

    public void setId_zone(int id_zone) {
        this.id_zone = id_zone;
    }

    public String getNom_zone() {
        return nom_zone;
    }

    public void setNom_zone(String nom_zone) {
        this.nom_zone = nom_zone;
    }
    @OneToMany
    private List<Pharmacie> ph;
    private int id_zone;
    private String nom_zone;
}
