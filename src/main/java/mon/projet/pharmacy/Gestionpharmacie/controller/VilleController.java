package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.*;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import mon.projet.pharmacy.Gestionpharmacie.repository.YourEntityRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.VilleService;
import mon.projet.pharmacy.Gestionpharmacie.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("api/ville")
public class VilleController {




@Autowired
    private VilleRepository villerepo;
    @Autowired
    private VilleService villeService;
@Autowired
private ZoneService zoneService;
    @Autowired // or use constructor injection
    public VilleController(VilleRepository villeRepository) {
        this.villerepo = villeRepository;
    }


    //add one
    @PostMapping("/save")
    public void save(@RequestBody Ville ville){
        villeService.save(ville);
    }

    @PutMapping("/update/{id}")
    public void updateCity(@PathVariable int id, @RequestBody Ville ville) {
        Ville existingCity = villeService.findById(id);
        if (existingCity != null) {
            existingCity.setNom(ville.getNom());
            villeService.save(existingCity);
        }

    }


//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable(required = true) String id) {
//        Ville ville = villerepo.findById(Integer.parseInt(id));
//        System.out.println("sssssssssssssssss"+ville.getNom());
//        villerepo.delete(ville);
//    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable int id) {
        Ville exist = villeService.findById(id);
        if(exist != null){
            villeService.delete(exist);
        }
        villeService.deleteCity(id);
    }
    //getAll
    @GetMapping("/all")
    public List<Ville> findAll(){
        return villeService.findAll();
    }

    @GetMapping("/get/{id}")
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



    @GetMapping("/v2")
    public String city(Model model){

        model.addAttribute("listVilles", villeService.findAll());
        return "/pages/city";
    }
    @RequestMapping("/v1")
public String viewPage(Model model){
        List<Ville> entities = villeService.findAll();
        model.addAttribute("listVilles", entities);
        System.out.println(entities+" dddddddd "+ entities.toString());
        System.out.println(entities);
        return "villePage";

    }


    @RequestMapping("/v3")
    public String displayTable(Model model) {
        List<Ville> entities = villerepo.findAll();
        model.addAttribute("entities", entities);
        System.out.println(entities+" dddddddd "+ entities.toString());
        return "test";
    }
}
