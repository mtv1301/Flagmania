package springboot.example.gameofflags.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.dto.PointsRequestDto;
import springboot.example.gameofflags.dto.UserRequestDto;
import springboot.example.gameofflags.exception.DuplicateEmailException;
import springboot.example.gameofflags.exception.UserNotFoundException;
import springboot.example.gameofflags.model.User;
import springboot.example.gameofflags.repository.UserRepository;

@Service
public class UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public void registerUser(UserRequestDto userRequestDto) throws DuplicateEmailException {
        Optional<User> userOptional = userRepository.findByEmail(userRequestDto.getEmail());
        if (userOptional.isPresent()) {
            throw new DuplicateEmailException("User with email: " + userRequestDto.getEmail() + " already exists.");
        } else {
            User user = prepareUser(userRequestDto);
            userRepository.save(user);
            LOG.info("User with " + userRequestDto.getEmail() + " was created.");
        }
    }

    public void changePointsFoUser(PointsRequestDto requestDto) throws UserNotFoundException {
        Optional<User> user = userRepository.getUserById(requestDto.getUserId());
        if (user.isEmpty()) {
            throw new UserNotFoundException("User with id: " + requestDto.getUserId() + " not found.");
        } else {
            if(requestDto.getIdAnswer().equals(requestDto.getIdFlag())) {
                var points = user.get().getPoints();
                user.get().setPoints(points + 1);
                userRepository.save(user.get());
            }
        }
    }

    public int getUserPoints(Long userId) throws Exception {
        var user = userRepository.getUserById(userId).orElseThrow(
                () -> new UserNotFoundException("User with id - "  + userId + " not found"));
        return user.getPoints();
    }

    private User prepareUser(UserRequestDto userRequestDto) {
        User user = new User();
        user.setName(userRequestDto.getName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        user.setPoints(0);
        return user;
    }
}
