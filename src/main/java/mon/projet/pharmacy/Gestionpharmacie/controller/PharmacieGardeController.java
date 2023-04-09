package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.PharmacieGarde;
import mon.projet.pharmacy.Gestionpharmacie.services.PharmacieGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gardepharmacie")
public class PharmacieGardeController {

    @Autowired
    private PharmacieGardeService pharmacieGardeService;
    @GetMapping("/All")
    public List<PharmacieGarde> getAll(){
        return pharmacieGardeService.getAll();
    }

    @PostMapping
    public void addGarde(@PathVariable PharmacieGarde pharmacieGarde){
         pharmacieGardeService.addGarde(pharmacieGarde);
    }
}
