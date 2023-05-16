package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.config.EazyBankUsernamePwdAuthenticationProvider;
import mon.projet.pharmacy.Gestionpharmacie.dto.UserRegistrationDto;
import mon.projet.pharmacy.Gestionpharmacie.entities.User;
import mon.projet.pharmacy.Gestionpharmacie.entities.Ville;
import mon.projet.pharmacy.Gestionpharmacie.entities.YourEntity;
import mon.projet.pharmacy.Gestionpharmacie.repository.VilleRepository;
import mon.projet.pharmacy.Gestionpharmacie.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    VilleRepository villeRepository;
        @RequestMapping("/login")
        public String loginPage(){
            return "auth-login";
        }

        @RequestMapping("/home")
        public String loginSubmit(){
            return "/pages/landing_page";
        }

    @GetMapping("/register")
    public String register(Model model) {
        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        model.addAttribute("userRegistrationDto", userRegistrationDto);

        return "pages/auth/register";
    }
    @PostMapping("/register")
    public String registerUserAccount(@Valid @ModelAttribute("userRegistrationDto") UserRegistrationDto userRegistrationDto, BindingResult result, Model model) {
        model.addAttribute("userRegistrationDto", userRegistrationDto);

        User userExists = userService.findByUsername(userRegistrationDto.getUserName());

        //System.out.println("user-->"+userRegistrationDto.getUserName());
        //System.out.println("userExists-->"+userExists);

        if (userExists != null) {
            return "redirect:/register?username";
        }
        if(result.hasErrors()){
            return "pages/auth/register";
        }
        userService.save(userRegistrationDto);
        return "redirect:/register?success";
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
