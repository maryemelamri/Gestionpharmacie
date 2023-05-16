package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.YourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YourEntityRepository extends JpaRepository<YourEntity, Long> {
    List<YourEntity> findAll();
    // Additional methods if needed
}
