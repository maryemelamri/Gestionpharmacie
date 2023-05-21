package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Date;
@Embeddable
public class PharmacieGardePK implements Serializable {

    private int pharmacie_id;
    private int garde_id;
    private Date dateDebut;

    public PharmacieGardePK(){super();}

    public PharmacieGardePK(int id_pharmacie, int id_garde, Date dateDebut) {
        super();
        this.pharmacie_id = id_pharmacie;
        this.garde_id = id_garde;
        this.dateDebut = dateDebut;
    }

    public int getId_pharmacie() {
        return pharmacie_id;
    }

    public void setId_pharmacie(int id_pharmacie) {
        this.pharmacie_id = id_pharmacie;
    }

    public int getId_garde() {
        return garde_id;
    }

    public void setId_garde(int id_garde) {
        this.garde_id = id_garde;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
}
