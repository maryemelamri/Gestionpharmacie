package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.dao.IDAO;
import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer>{
    Ville findById(int id);

    Ville findByNom(String nom);


}
