package springboot.example.gameofflags.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.example.gameofflags.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAll();

    Optional<Country> findById(Long id);
}
