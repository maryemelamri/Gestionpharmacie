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



    public Garde() {
        super();
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
