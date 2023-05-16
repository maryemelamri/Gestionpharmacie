package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}