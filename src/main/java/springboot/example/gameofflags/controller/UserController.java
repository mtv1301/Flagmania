package springboot.example.gameofflags.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.gameofflags.dto.request.ChangePointsRequest;
import springboot.example.gameofflags.dto.mapper.UserMapper;
import springboot.example.gameofflags.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
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
