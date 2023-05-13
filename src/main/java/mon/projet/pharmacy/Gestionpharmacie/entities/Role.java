package mon.projet.pharmacy.Gestionpharmacie.entities;

import jakarta.persistence.*;

import java.util.List;


public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_role;

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
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }


}
