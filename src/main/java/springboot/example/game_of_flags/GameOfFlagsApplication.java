package springboot.example.game_of_flags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class GameOfFlagsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameOfFlagsApplication.class, args);
    }
}
