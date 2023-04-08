package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Pharmacie;
import mon.projet.pharmacy.Gestionpharmacie.services.PharmacieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pharmacie")
public class PharmacieController {
@Autowired
PharmacieService pharmacieService;
    @PostMapping(value = "/save", consumes = {"application/json"})
    public void Save(@RequestBody Pharmacie pharmacie){ pharmacieService.save(pharmacie);}

    @GetMapping("/all")
    public List<Pharmacie> findAll(){
        return pharmacieService.findAll();
    }




    }
