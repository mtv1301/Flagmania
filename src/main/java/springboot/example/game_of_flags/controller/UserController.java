package springboot.example.game_of_flags.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ApiOperation(value = "Register a new user")
    public void registerUser(@RequestBody RegistrationRequest request)
            throws DuplicateEmailException {
        userService.registerUser(userMapper.toUserRequestDto(request));
    }

    @PutMapping("/points")
    @ApiOperation(value = "Add points to user")
    public void countPointsForUser(@RequestParam @ApiParam(value = "true flag id") Long idFlag,
                                   @RequestParam @ApiParam(value = "answered flag id") Long idAnswer,
                                   @RequestParam @ApiParam(value = "user id") Long userId) {
        userService.changePointsFoUser(userId, idFlag, idAnswer);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get user's points")
    public int getUserPoints(@PathVariable Long id) {
        return userService.getUserPoints(id);
    }
}
