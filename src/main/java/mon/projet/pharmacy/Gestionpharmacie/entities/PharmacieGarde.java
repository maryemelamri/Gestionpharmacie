package mon.projet.pharmacy.Gestionpharmacie.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name="pharmacie_garde")
public class PharmacieGarde {
    @EmbeddedId
    private PharmacieGardePK pk;

    private Date dateFin;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="pharmacie_id",insertable = false,updatable = false)
    private Pharmacie pharmacie;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="garde_id",insertable = false,updatable = false)
    private Garde garde;

    public PharmacieGarde(){super();}



    public PharmacieGardePK getPk() {
        return pk;
    }

    public void setPk(PharmacieGardePK pk) {
        this.pk = pk;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Pharmacie getPharmacie() {
        return pharmacie;
    }

    public void setPharmacie(Pharmacie pharmacie) {
        this.pharmacie = pharmacie;
    }

    public Garde getGarde() {
        return garde;
    }

    public void setGarde(Garde garde) {
        this.garde = garde;
    }
}
