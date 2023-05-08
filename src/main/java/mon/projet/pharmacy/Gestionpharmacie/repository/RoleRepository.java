package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByAuthority(String authority);
}
