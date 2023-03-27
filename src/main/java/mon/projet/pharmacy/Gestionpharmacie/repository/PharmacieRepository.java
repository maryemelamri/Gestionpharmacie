package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacieRepository extends JpaRepository<Pharmacie, Integer> {
    Pharmacie findByNom(String nom);

}
