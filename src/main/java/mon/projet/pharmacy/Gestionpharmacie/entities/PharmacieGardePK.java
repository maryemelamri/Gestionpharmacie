package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
@Embeddable
public class PharmacieGardePK implements Serializable {

    private int id_pharmacie;
    private int id_garde;
    private Date dateDebut;

    public PharmacieGardePK(){super();}

    public int getId_pharmacie() {
        return id_pharmacie;
    }

    public void setId_pharmacie(int id_pharmacie) {
        this.id_pharmacie = id_pharmacie;
    }

    public int getId_garde() {
        return id_garde;
    }

    public void setId_garde(int id_garde) {
        this.id_garde = id_garde;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
}
