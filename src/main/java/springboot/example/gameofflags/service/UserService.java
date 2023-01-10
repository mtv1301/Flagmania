package springboot.example.gameofflags.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.example.gameofflags.dto.PointsRequestDto;
import springboot.example.gameofflags.dto.UserRequestDto;
import springboot.example.gameofflags.exception.DuplicateEmailException;
import springboot.example.gameofflags.exception.EntityNotFoundException;
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

    public void changePointsFoUser(PointsRequestDto requestDto) throws EntityNotFoundException {
        User user = userRepository.getUserById(requestDto.getUserId()).orElseThrow(
                () -> new EntityNotFoundException("User with id: "  + requestDto.getUserId() + " not found"));
        if(requestDto.getAnswerId().equals(requestDto.getFlagId())){
            int points = user.getPoints();
            user.setPoints(points + 1);
            userRepository.save(user);
        }
    }

    public int getUserPoints(Long userId) throws Exception {
        User user = userRepository.getUserById(userId).orElseThrow(
                () -> new EntityNotFoundException("User with id - "  + userId + " not found"));
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
