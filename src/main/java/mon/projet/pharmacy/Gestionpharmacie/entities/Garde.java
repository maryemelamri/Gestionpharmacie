package mon.projet.pharmacy.Gestionpharmacie.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Garde {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id_garde;
    private String type;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "garde")
    private List<PharmacieGarde> phramcieGarde;

    public Garde() {
        super();
    }

    public int getId_garde() {
        return id_garde;
    }

    public void setId_garde(int id_garde) {
        this.id_garde = id_garde;
    }
    public List<PharmacieGarde> getPhramcieGarde() {
        return phramcieGarde;
    }

    public void setPhramcieGarde(List<PharmacieGarde> phramcieGarde) {
        this.phramcieGarde = phramcieGarde;
    }
    public int getInd_garde() {
        return id_garde;
    }

    public void setInd_garde(int id_garde) {
        this.id_garde = id_garde;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
