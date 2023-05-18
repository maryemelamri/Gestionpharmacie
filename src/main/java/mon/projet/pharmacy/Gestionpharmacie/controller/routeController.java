package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class routeController {
        @Autowired
        VilleRepository villeRepository;
        @RequestMapping("/city")
        public String city(Model model){
            List<Ville> entities = villeRepository.findAll();
            model.addAttribute("entities", entities);
            System.out.println(entities+" dddddddd "+ entities.toString());
            return "pages/city";
        }

        @RequestMapping("/home")
        public String loginSubmit(){
            return "/pages/landing_page";
        }


}
