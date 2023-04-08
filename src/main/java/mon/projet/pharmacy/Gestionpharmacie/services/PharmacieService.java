package mon.projet.pharmacy.Gestionpharmacie.services;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacieService {

   @Autowired
 private PharmacieRepository pharmcieRepository;

    public void save(Pharmacie pharmacie) {
        pharmcieRepository.save(pharmacie);
    }

    public List<Pharmacie> findAll() {
       return pharmcieRepository.findAll();
    }
}
