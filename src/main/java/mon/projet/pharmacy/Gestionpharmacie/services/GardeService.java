package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.entities.Garde;
import mon.projet.pharmacy.Gestionpharmacie.repository.GardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class GardeService {



    @Autowired
    private GardeRepository pharmcieRepository;


    public void save(Garde garde) {
        pharmcieRepository.save(garde);
    }

    public List<Garde> findAll() {
        return pharmcieRepository.findAll();
    }
}
