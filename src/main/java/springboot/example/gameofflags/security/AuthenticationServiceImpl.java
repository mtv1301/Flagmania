package springboot.example.gameofflags.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.repository.AuthenticationRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public Optional<User> login(String email, String password) {
        return authenticationRepository.findByEmailAndPassword(email, password);
    }
}
