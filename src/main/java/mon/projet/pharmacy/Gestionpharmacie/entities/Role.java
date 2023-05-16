package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Role {

    public Role() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "role_id")

    private int id;

    private  String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String description;

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_role() {
        return id;
    }

    public void setId_role(int id_role) {
        this.id = id_role;
    }


}
