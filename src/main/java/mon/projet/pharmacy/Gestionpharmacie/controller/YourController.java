package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.YourEntity;
import mon.projet.pharmacy.Gestionpharmacie.repository.YourEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class YourController {
    private YourEntityRepository yourEntityRepository;

    // Constructor injection or @Autowired

    @Autowired // or use constructor injection
    public YourController(YourEntityRepository yourEntityRepository) {
        this.yourEntityRepository = yourEntityRepository;
    }
    @RequestMapping("/your-path")
    public String displayTable(Model model) {
        List<YourEntity> entities = yourEntityRepository.findAll();
        model.addAttribute("entities", entities);
        System.out.println(entities+" dddddddd "+ entities.toString());
        return "your-template-name";
    }
}
