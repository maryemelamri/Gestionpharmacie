package mon.projet.pharmacy.Gestionpharmacie.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {


    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                    try {

                        requests
                                .requestMatchers("/public/**").permitAll()
                                .requestMatchers("/private/**").authenticated()
                                .and()
                                .formLogin()
                                .loginPage("/login")
                                .defaultSuccessUrl("/home")
                                .permitAll()
                                .and()
                                .logout()
                                .logoutUrl("/logout")
                                .permitAll();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                );

    return  http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
    }
}
