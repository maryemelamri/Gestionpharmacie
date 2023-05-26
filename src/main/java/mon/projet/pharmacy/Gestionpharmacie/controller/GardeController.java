package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Garde;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.repository.GardeRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.GardeService;
import mon.projet.pharmacy.Gestionpharmacie.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/garde")
@CrossOrigin
public class GardeController {
@Autowired
    private GardeService gardeService;
@Autowired
    private GardeRepository gardeRepository;
@Autowired
    private ZoneService zoneService;


    @PostMapping("/save")
    public void save (@RequestBody Garde garde){
         gardeService.save(garde);
    }
    @GetMapping("/all")
    public List<Garde> findAll(){ return gardeService.findAll();}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(required = true) int id) {
        Garde s = gardeRepository.findById(id);
        gardeRepository.delete(s);
    }
    @PutMapping("/update/{id}")
    public void update(@PathVariable int id, @RequestBody Garde garde) {
        Garde existing = gardeRepository.findById(id);
        if (existing != null) {
            existing.setType(garde.getType());
            gardeService.save(existing);
        }

    }
    @GetMapping(value = "/count")
    public long countGarde() {
        return gardeRepository.count();
    }


}
