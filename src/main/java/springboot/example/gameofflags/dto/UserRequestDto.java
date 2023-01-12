package springboot.example.gameofflags.dto;

import lombok.Data;
import springboot.example.gameofflags.validation.Email;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
}
