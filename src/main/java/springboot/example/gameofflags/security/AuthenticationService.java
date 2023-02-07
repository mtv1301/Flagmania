package springboot.example.gameofflags.security;

import java.util.Optional;
import javax.naming.AuthenticationException;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.model.User;

@Service
public interface AuthenticationService {
    Optional<User> login(String login, String password) throws AuthenticationException;
}
