package springboot.example.gameofflags.dto.request;

import lombok.Data;
import springboot.example.gameofflags.validation.Email;
import springboot.example.gameofflags.validation.Password;

@Data
public class RegistrationRequest {
    private String name;
    @Email()
    private String email;
    @Password()
    private String password;
}
