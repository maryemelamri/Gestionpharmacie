package mon.projet.pharmacy.Gestionpharmacie.services.facade;

import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface RoleServices {
    Role save (Role role);
    void save (Collection<Role> roles);
    Role findByAuthority(String authority);
}
