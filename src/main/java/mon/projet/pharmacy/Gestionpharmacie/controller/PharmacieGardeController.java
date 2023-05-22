package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.PharmacieGarde;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieGardeRepositry;
import mon.projet.pharmacy.Gestionpharmacie.repository.PharmacieGardeRepositry;
import mon.projet.pharmacy.Gestionpharmacie.services.PharmacieGardeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("phramacieGarde")
@CrossOrigin
public class PharmacieGardeController {

    @Autowired
    private PharmacieGardeRepositry pharmacieGardeRepository;
    @Autowired
    private PharmacieGardeService            pharmacieGardeService;


    @PostMapping("/save")
    public void save(@RequestBody PharmacieGarde pharmacieGarde) {
        pharmacieGardeRepository.save(pharmacieGarde);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(required = true) int id) {
        PharmacieGarde s = pharmacieGardeRepository.findById(id);
        pharmacieGardeRepository.delete(s);
    }

    @GetMapping("/all")
    public List<PharmacieGarde> findAll() {
        return pharmacieGardeRepository.findAll();
    }

    @GetMapping(value = "/count")
    public long countResto() {
        return pharmacieGardeRepository.count();
    }

    @GetMapping("/findbySpecId/{id}")
    public List<PharmacieGarde> findAllById(@PathVariable(required = false) String id){
        PharmacieGarde v = pharmacieGardeRepository.findById(Integer.parseInt(id));
        return (List<PharmacieGarde>) v.getGarde();
    }


    @PostMapping
    public void addGarde(@PathVariable PharmacieGarde pharmacieGarde){
        pharmacieGardeService.addGarde(pharmacieGarde);
    }
}
