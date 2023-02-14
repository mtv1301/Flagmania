package springboot.example.gameofflags.controller;

import java.util.Optional;
import javax.naming.AuthenticationException;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.example.gameofflags.dto.AuthenticationDto;
import springboot.example.gameofflags.dto.mapper.UserMapper;
import springboot.example.gameofflags.dto.request.RegistrationRequest;
import springboot.example.gameofflags.dto.request.UserLoginRequest;
import springboot.example.gameofflags.exception.DuplicateEmailException;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.security.AuthenticationService;
import springboot.example.gameofflags.security.jwt.JwtTokenProvider;
import springboot.example.gameofflags.service.UserService;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private AuthenticationService authenticationService;

    public AuthenticationController(UserService userService,
                                    UserMapper userMapper,
                                    JwtTokenProvider jwtTokenProvider,
                                    AuthenticationService authenticationService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/registration")
    public void registerUser(@Valid @RequestBody RegistrationRequest request)
            throws DuplicateEmailException {
        userService.registerUser(userMapper.toUserRequestDto(request));
    }

    @PostMapping("/login")
    public AuthenticationDto login(@Valid @RequestBody UserLoginRequest request)
            throws AuthenticationException {
        Optional<User> user = authenticationService.login(request.getEmail(), request.getPassword());
        return jwtTokenProvider.createToken(user.get().getEmail());
    }
}
