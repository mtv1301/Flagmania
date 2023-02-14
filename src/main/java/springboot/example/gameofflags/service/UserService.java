package springboot.example.gameofflags.service;

import java.util.Optional;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.dto.PointsRequestDto;
import springboot.example.gameofflags.dto.UserRequestDto;
import springboot.example.gameofflags.exception.DuplicateEmailException;
import springboot.example.gameofflags.exception.EntityNotFoundException;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.repository.UserRepository;

@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRequestDto userRequestDto) throws DuplicateEmailException {
        Optional<User> userOptional = userRepository.findByEmail(userRequestDto.getEmail());
        if (userOptional.isPresent()) {
            throw new DuplicateEmailException(
                    "User with email: " + userRequestDto.getEmail() + " already exists.");
        }
        User user = prepareUser(userRequestDto);
        userRepository.save(user);
        log.info("User with " + userRequestDto.getEmail() + " was created.");
    }

    public void changePointsFoUser(PointsRequestDto requestDto) throws EntityNotFoundException {
        User user = findUserById(requestDto.getUserId());
        if (requestDto.getAnswerId().equals(requestDto.getFlagId())){
            int points = user.getPoints();
            user.setPoints(points + 1);
            userRepository.save(user);
        }
    }

    public int getUserPoints(Long userId) throws Exception {
        return findUserById(userId).getPoints();
    }

    private User prepareUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        user.setPoints(0);
        return user;
    }

    private User findUserById(Long userId) throws EntityNotFoundException {
       return userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User with id - "  + userId + " not found"));
    }
}