package springboot.example.game_of_flags.exception;

public class DuplicateEmailException extends Exception {
    public DuplicateEmailException(String errorMessage) {
        super(errorMessage);
    }
}
