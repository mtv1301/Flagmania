package springboot.example.gameofflags.dto.request;

import javax.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import springboot.example.gameofflags.validation.Email;
import springboot.example.gameofflags.validation.Password;

@Data
@NoArgsConstructor
public class RegistrationRequest {
    @NonNull
    @Size(min = 4)
    private String name;
    @Email()
    private String email;
    @Password()
    private String password;
}
