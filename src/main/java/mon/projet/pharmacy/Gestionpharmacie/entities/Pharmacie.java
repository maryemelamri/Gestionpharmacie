package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pharmacie {
    @Id
    private int id_phar;

    public int getId_phar() {
        return id_phar;
    }

    public void setId_phar(int id_phar) {
        this.id_phar = id_phar;
    }

    public String getNom_phar() {
        return nom_phar;
    }

    public void setNom_phar(String nom_phar) {
        this.nom_phar = nom_phar;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLag() {
        return lag;
    }

    public void setLag(double lag) {
        this.lag = lag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String nom_phar;

    public Pharmacie() {
    }

    private String adress;
    private double lat;
    private double lag;
    private String photo;



    private int status;
}
