package springboot.example.gameofflags.controller;

import java.util.Map;
import java.util.Optional;
import javax.naming.AuthenticationException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    @Autowired
    private final UserService userService;
    @Autowired
    private final AuthenticationService authenticationService;
    @Autowired
    private final UserMapper userMapper;
    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(UserService userService, AuthenticationService authenticationService,
                                    UserMapper userMapper, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/registration")
    public void registerUser(@Valid @RequestBody RegistrationRequest request)
            throws DuplicateEmailException {
        userService.registerUser(userMapper.toUserRequestDto(request));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody UserLoginRequest request)
            throws AuthenticationException {
        Optional<User> user = authenticationService.login(request.getEmail(), request.getPassword());
        if (!user.isPresent()) {
            throw new AuthenticationException();
        }
        String token = jwtTokenProvider.createToken(user.get().getEmail());
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
