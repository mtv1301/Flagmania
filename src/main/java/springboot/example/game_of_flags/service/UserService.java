package springboot.example.game_of_flags.service;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.example.game_of_flags.dto.UserRequestDto;
import springboot.example.game_of_flags.exception.DuplicateEmailException;
import springboot.example.game_of_flags.model.User;
import springboot.example.game_of_flags.repository.UserRepository;

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

    public void changePointsFoUser(Long userId, Long idFlag, Long idAnswer) {
        var user = userRepository.getUserById(userId).get();
        if(idAnswer.equals(idFlag)){
            var points = user.getPoints();
            user.setPoints(points + 1);
            userRepository.save(user);
        }
    }

    public int getUserPoints(Long userId) {
        var user = userRepository.getUserById(userId).get();
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
