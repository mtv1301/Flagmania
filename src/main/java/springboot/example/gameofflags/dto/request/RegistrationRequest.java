package springboot.example.gameofflags.dto.request;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String name;
    private String email;
    private String password;
}
