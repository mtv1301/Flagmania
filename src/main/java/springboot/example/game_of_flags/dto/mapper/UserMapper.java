package springboot.example.game_of_flags.dto.mapper;

import org.springframework.stereotype.Component;
import springboot.example.game_of_flags.dto.UserRequestDto;
import springboot.example.game_of_flags.model.RegistrationRequest;

@Component
public class UserMapper {
    public UserRequestDto toUserRequestDto(RegistrationRequest request){
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName(request.getName());
        userRequestDto.setEmail(request.getEmail());
        userRequestDto.setPassword(request.getPassword());
        return userRequestDto;
    }
}
