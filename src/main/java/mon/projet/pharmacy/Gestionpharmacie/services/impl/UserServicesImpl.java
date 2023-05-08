/*
package mon.projet.pharmacy.Gestionpharmacie.services.impl;


import mon.projet.pharmacy.Gestionpharmacie.entities.User;

import mon.projet.pharmacy.Gestionpharmacie.repository.UserRepository;

import mon.projet.pharmacy.Gestionpharmacie.services.facade.UserServices;
import mon.projet.pharmacy.Gestionpharmacie.services.facade.RoleServices;
import mon.projet.pharmacy.Gestionpharmacie.services.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class UserServicesImpl implements UserServices {
    @Autowired private UserRepository userDao;
    @Autowired private RoleServices roleService;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JwtUtil jwtUtil;

    private UserRepository userRepository;

    public UserServicesImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public String singIn(User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(), user.getPassword()
            ));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("bad creditiel for username " + user.getUsername());
        }
        User loadUserByUsername = loadUserByUsername(user.getUsername());
        String token = jwtUtil.generateToken(loadUserByUsername);
        return token;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
*/
