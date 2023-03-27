package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.Garde;
import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardeRepository extends JpaRepository<Garde, Integer> {
    Garde findByType(String type);
}
