package springboot.example.game_of_flags.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
}
