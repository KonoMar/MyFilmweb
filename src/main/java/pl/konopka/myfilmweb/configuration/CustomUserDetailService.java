package pl.konopka.myfilmweb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.konopka.myfilmweb.model.User;
import pl.konopka.myfilmweb.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        User userByUsername = userRepository.findByUsername(login);

        if (userByUsername == null) {
            throw new UsernameNotFoundException("Not Found");
        }

        String username = userByUsername.getUsername();
        String password = userByUsername.getPassword();
        boolean isEnabled = userByUsername.isEnabled();
        Set<GrantedAuthority> grantedAuthorities = getGrantedAuthorities(userByUsername);

        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                username, password, isEnabled, true, true, true, grantedAuthorities);

        return user;
    }

    private Set<GrantedAuthority> getGrantedAuthorities(User userByUsername) {

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority(userByUsername.getRole()));

        return grantedAuthorities;

    }
}
