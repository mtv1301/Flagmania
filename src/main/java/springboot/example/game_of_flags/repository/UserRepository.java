package springboot.example.game_of_flags.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import springboot.example.game_of_flags.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
