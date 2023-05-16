package mon.projet.pharmacy.Gestionpharmacie.services;


import mon.projet.pharmacy.Gestionpharmacie.dto.UserRegistrationDto;
import mon.projet.pharmacy.Gestionpharmacie.entities.Role;
import mon.projet.pharmacy.Gestionpharmacie.entities.User;
import mon.projet.pharmacy.Gestionpharmacie.repository.IRoleRepository;
import mon.projet.pharmacy.Gestionpharmacie.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;


//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(IUserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        //Creating admin role user
        User user = new User(
                registrationDto.getUserName(),
                registrationDto.getPassword(),
//                passwordEncoder.encode(registrationDto.getPassword()),
                Arrays.asList(roleRepository.findByRole("ADMIN")));

        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPwd(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }

}
