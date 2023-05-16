package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


}
