package springboot.example.gameofflags.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class AuthenticationDto {
    private String token;
    private HttpStatus status;
}
