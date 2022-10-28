package springboot.example.game_of_flags.model;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;
}
