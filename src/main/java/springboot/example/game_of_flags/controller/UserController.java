package springboot.example.game_of_flags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.game_of_flags.dto.mapper.UserMapper;
import springboot.example.game_of_flags.exception.DuplicateEmailException;
import springboot.example.game_of_flags.model.RegistrationRequest;
import springboot.example.game_of_flags.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public void registerUser(@RequestBody RegistrationRequest request) throws DuplicateEmailException {
        userService.registerUser(userMapper.toUserRequestDto(request));
    }

    @PutMapping("/points")
    public void countPointsForUser(@RequestParam Long idFlag,
                                   @RequestParam Long idAnswer,
                                   @RequestParam Long userId) {
        userService.changePointsFoUser(userId, idFlag, idAnswer);
    }
}
