package springboot.example.gameofflags.security;

import java.util.Optional;
import javax.naming.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(String email, String password) throws AuthenticationException {
        boolean password_verified;
        Optional<User> user = userRepository.findByEmail(email);
        password_verified = BCrypt.checkpw(password, user.get().getPassword());
        if (password_verified) {
            return user;
        } else {
            throw new AuthenticationException("The email: " + email + " or password: " + password + " is incorrect.");
        }
    }
}
