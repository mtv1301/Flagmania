package springboot.example.gameofflags.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.gameofflags.dto.request.ChangePointsRequest;
import springboot.example.gameofflags.dto.mapper.UserMapper;
import springboot.example.gameofflags.exception.DuplicateEmailException;
import springboot.example.gameofflags.dto.request.RegistrationRequest;
import springboot.example.gameofflags.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public void registerUser(@RequestBody RegistrationRequest request)
            throws DuplicateEmailException {
        userService.registerUser(userMapper.toUserRequestDto(request));
    }

    @PutMapping("/points")
    public void countPointsForUser(@RequestBody ChangePointsRequest request)
            throws Exception {
        userService.changePointsFoUser(userMapper.toPointsRequestDto(request));
    }

    @GetMapping("/{id}")
    public int getUserPoints(@PathVariable Long id) throws Exception {
        return userService.getUserPoints(id);
    }
}
