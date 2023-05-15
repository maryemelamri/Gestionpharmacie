package mon.projet.pharmacy.Gestionpharmacie.controller;

import mon.projet.pharmacy.Gestionpharmacie.config.EazyBankUsernamePwdAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
        @RequestMapping("/login")
        public String loginPage(){
            return "auth-login";
        }

        @RequestMapping("/home")
        public String loginSubmit(){
            return "/pages/landing_page";
        }
        @RequestMapping("/city")
        public String city(){
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
