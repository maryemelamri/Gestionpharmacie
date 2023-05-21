package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.entities.Zone;
import mon.projet.pharmacy.Gestionpharmacie.services.VilleService;
import mon.projet.pharmacy.Gestionpharmacie.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("api/zones")
    @CrossOrigin
    public class ZoneController {

        @Autowired
        private ZoneService zoneService;
        @Autowired
        private VilleService villeService;

        @GetMapping("/villes/{ville}/zones")
        public List<Zone> findByVille(@PathVariable int ville){
            Ville v = villeService.findById(ville);
            return zoneService.findByVilleId(v.getId());
        }

        @GetMapping("")
        public List<Zone> findAll(){
            return zoneService.findAll();
        }

        @PostMapping("/save")
        public void save(@RequestBody Zone zone){
            zoneService.save(zone);
        }

        @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable int id){
            Zone z = zoneService.findById(id);
            if(z != null)
                zoneService.delete(z);
        }

        @PutMapping("/update")
        public void update(@RequestBody Zone z){
            zoneService.update(z);
        }

        @GetMapping("/ville/{nom}")
        public Zone findByNom(@PathVariable String nom){
            return zoneService.findByNom(nom);
        }
    }


