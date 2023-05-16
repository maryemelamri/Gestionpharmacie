package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.dto.UserRegistrationDto;
import mon.projet.pharmacy.Gestionpharmacie.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);
}