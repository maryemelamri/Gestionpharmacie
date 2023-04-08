package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.entities.PharmacieGarde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacieGardeRepositry extends JpaRepository<PharmacieGarde, Integer> {

}
