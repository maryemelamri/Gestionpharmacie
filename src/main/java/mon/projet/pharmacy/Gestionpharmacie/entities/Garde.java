package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Garde {
   @Id
    private int ind_garde;
    private String type;

    public Garde() {
    }

    public int getInd_garde() {
        return ind_garde;
    }

    public void setInd_garde(int ind_garde) {
        this.ind_garde = ind_garde;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
