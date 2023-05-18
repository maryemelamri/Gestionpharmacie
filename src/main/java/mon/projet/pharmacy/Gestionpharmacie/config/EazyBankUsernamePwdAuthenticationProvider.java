package mon.projet.pharmacy.Gestionpharmacie.config;


import mon.projet.pharmacy.Gestionpharmacie.entities.User;

import mon.projet.pharmacy.Gestionpharmacie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EazyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) {
		String username = authentication.getName();
		String pwd = authentication.getCredentials().toString();
		List<User> user = userRepository.findByEmail(username);
		System.out.println("*********** "+ username);
		if (user.size() > 0) {
			System.out.println("im here"+ username);
			if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
				System.out.println("tani hna"+ username);
				List<GrantedAuthority> authorities = new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
				return new UsernamePasswordAuthenticationToken(username, pwd, authorities);

			} else {
				System.out.println("Invalid"+ username);
				throw new BadCredentialsException("Invalid password!");
			}
		}else {
			System.out.println("No user registered "+ username);
			throw new BadCredentialsException("No user registered with this details!");
		}
	}

	@Override
	public boolean supports(Class<?> authenticationType) {
		System.out.println("my token ++++++"+UsernamePasswordAuthenticationToken.class);
		return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
	}
}

