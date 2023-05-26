package mon.projet.pharmacy.Gestionpharmacie.services;


import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
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

    public Zone findById(int id) {
        return zoneRepository.findById(id);
    }
    public void delete(Zone o){
        // TODO Auto-generated method stub
        Zone zone = zoneRepository.findById(o.getId());
        if (zone != null)
            zoneRepository.delete(zone);

    }
    public void update(Zone zoneUp) {
        // TODO Auto-generated method stub
        Zone zone = zoneRepository.findById(zoneUp.getId());
        zone.setNom(zoneUp.getNom());
        zone.setVille(zoneUp.getVille());
        zoneRepository.save(zone);
    }

    public List<Zone> findByVilleId(int id) {
        return zoneRepository.findByVilleId(id);
    }
}