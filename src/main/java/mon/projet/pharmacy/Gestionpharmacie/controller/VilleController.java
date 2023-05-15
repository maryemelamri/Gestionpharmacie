package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Garde;
import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.entities.Zone;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.VilleService;
import mon.projet.pharmacy.Gestionpharmacie.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class VilleController {
@Autowired
    private VilleService villeService;
@Autowired
private ZoneService zoneService;

@Autowired
private VilleRepository villeRepository;
    //add one
    @PostMapping("api/save")
    public void save(@RequestBody Ville ville){
        villeService.save(ville);
    }

    @PutMapping("api/{id}")
    public void updateCity(@PathVariable int id, @RequestBody Ville ville) {
        Ville existingCity = villeService.findById(id);
        if (existingCity != null) {
            existingCity.setNom(ville.getNom());
            villeService.save(existingCity);
        }

    }


    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
        villeService.delete(id);
    }
    //getAll
    @GetMapping("/villes")
    public List<Ville> findAll(){
        return villeService.findAll();
    }

    @GetMapping("/villes/{id}")
    public Ville getId(@PathVariable int id){
        Ville v= villeService.findById(id);
      return v;
    }

        @GetMapping("/{nom}/zones")
    public List<Zone> findByVille(@PathVariable String nom) {
        Ville ville = villeService.findByNom(nom);
        return ville.getZones();

    }

    @GetMapping("/villes/{nom}/zones/{nom2}/pharmacies")
    public List<Pharmacie> findByPharmacie(@PathVariable String nom, @PathVariable String nom2){
        Ville v = villeService.findByNom(nom);//marrkech
        Zone z = zoneService.findByNom(nom2);//massirq
        System.out.println("hey"+z);
        List<Zone> list = v.getZones();
        for (Zone z1 :
                list) {
            if (z1.equals(z)){
                return z.getPh();
            }


        }
      return null;
    }


public List<Garde> findByGarde(@PathVariable String ville, @PathVariable String zone, @PathVariable String garde ){
        Ville v = villeService.findByNom(ville);
        Zone z = zoneService.findByNom(zone);


        return null;
}
}
