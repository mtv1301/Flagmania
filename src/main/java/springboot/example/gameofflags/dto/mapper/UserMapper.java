package springboot.example.gameofflags.dto.mapper;

import org.springframework.stereotype.Component;
import springboot.example.gameofflags.dto.request.ChangePointsRequest;
import springboot.example.gameofflags.dto.PointsRequestDto;
import springboot.example.gameofflags.dto.UserRequestDto;
import springboot.example.gameofflags.dto.request.RegistrationRequest;

@Component
public class UserMapper {
    public UserRequestDto toUserRequestDto(RegistrationRequest request){
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setName(request.getName());
        userRequestDto.setEmail(request.getEmail());
        userRequestDto.setPassword(request.getPassword());
        return userRequestDto;
    }

    public PointsRequestDto toPointsRequestDto(ChangePointsRequest request){
        PointsRequestDto pointsRequestDto = new PointsRequestDto();
        pointsRequestDto.setUserId(request.getUserId());
        pointsRequestDto.setFlagId(request.getFlagId());
        pointsRequestDto.setAnswerId(request.getAnswerId());
        return pointsRequestDto;
    }
}
