package springboot.example.gameofflags.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.exception.EntityNotFoundException;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("User with email: " + email + " not found"));
        org.springframework.security.core.userdetails.User.UserBuilder builder =
                org.springframework.security.core.userdetails.User.withUsername(email);
        builder.password(user.getPassword());
        builder.authorities(getAuthorities());
        return builder.build();
    }
}
