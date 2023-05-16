package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class LoginController {
    @Autowired
    VilleRepository villeRepository;
        @RequestMapping("login")
        public String loginPage(){
            return "auth/auth-login";
        }

        @RequestMapping("/home")
        public String loginSubmit(){
            return "/pages/landing_page";
        }
        @RequestMapping("/city")
        public String city(Model model){
            List<Ville> entities = villeRepository.findAll();
            model.addAttribute("entities", entities);
            System.out.println(entities+" dddddddd "+ entities.toString());
            return "/pages/city";
        }
/*
    @Autowired
    private EazyBankUsernamePwdAuthenticationProvider authProvider;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authProvider.authenticate(authToken);
        } catch (Exception e) {
            return "redirect:/login?error";
        }

        return "redirect:/";
    }*/
}
