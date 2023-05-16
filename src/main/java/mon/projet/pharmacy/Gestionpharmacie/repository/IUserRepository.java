package mon.projet.pharmacy.Gestionpharmacie.repository;

import mon.projet.pharmacy.Gestionpharmacie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {  User findByEmail(String email);
}
