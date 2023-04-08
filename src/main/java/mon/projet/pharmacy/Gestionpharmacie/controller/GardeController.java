package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Garde;

import mon.projet.pharmacy.Gestionpharmacie.services.GardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Gardes")
public class GardeController {
@Autowired
    private GardeService gardeService;


    @PostMapping(value = "/save", consumes = {"application/json"})
    public void save (@RequestBody Garde garde){
         gardeService.save(garde);
    }
    @GetMapping("/all")
    public List<Garde> findAll(){ return gardeService.findAll();}

}
