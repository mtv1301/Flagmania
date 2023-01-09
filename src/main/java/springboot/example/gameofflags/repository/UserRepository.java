package springboot.example.gameofflags.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.example.gameofflags.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> getUserById(Long id);
}
