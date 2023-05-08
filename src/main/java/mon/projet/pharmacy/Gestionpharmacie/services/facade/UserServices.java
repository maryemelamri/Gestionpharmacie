package mon.projet.pharmacy.Gestionpharmacie.services.facade;

import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import mon.projet.pharmacy.Gestionpharmacie.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserServices {
    String singIn (User user);
    User save(User user);
    List<User> findAll();
}
