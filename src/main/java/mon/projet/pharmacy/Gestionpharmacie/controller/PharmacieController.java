package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pharmacie")
public class PharmacieController {
@Autowired
PharmacieService pharmacieService;
@Autowired
 PharmacieRepository pharmacieRepository;
    @PostMapping( "/save")
    public void Save(@RequestBody Pharmacie pharmacie){ pharmacieService.save(pharmacie);}


    @GetMapping("/all")
    public List<Pharmacie> findAll(){
        return pharmacieService.findAll();
    }


 @DeleteMapping("/delete/{id}")
 public void delete(@PathVariable(required = true) String id) {
  Pharmacie s = pharmacieRepository.findById(Integer.parseInt(id));
  pharmacieRepository.delete(s);
 }

 @PutMapping("/update/{id}")
 public void update(@PathVariable int id, @RequestBody Pharmacie pharmacie) {
  Pharmacie existingPha = pharmacieRepository.findById(id);
  if (existingPha != null) {
   existingPha.setNom(pharmacie.getNom());
   pharmacieService.save(existingPha);
  }

 }

}
