package springboot.example.gameofflags.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.example.gameofflags.validation.Email;
import springboot.example.gameofflags.validation.Password;

@Data
@NoArgsConstructor
public class UserLoginRequest {
    @Email()
    private String email;
    @Password()
    private String password;
}
