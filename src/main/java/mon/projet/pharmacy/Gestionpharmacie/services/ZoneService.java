package mon.projet.pharmacy.Gestionpharmacie.services;


import mon.projet.pharmacy.Gestionpharmacie.entities.Zone;
import mon.projet.pharmacy.Gestionpharmacie.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;
    public void save( Zone zone){
        zoneRepository.save(zone);
    }

    public List<Zone> findAll(){
        return zoneRepository.findAll();
    }


    public Zone findByNom(String nom) {
        return zoneRepository.findByNom(nom);
    }
}