package springboot.example.gameofflags.exception;

public class DuplicateEmailException extends Exception {
    public DuplicateEmailException(String errorMessage) {
        super(errorMessage);
    }
}
