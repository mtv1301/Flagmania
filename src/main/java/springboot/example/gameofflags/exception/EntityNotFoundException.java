package springboot.example.gameofflags.exception;

public class EntityNotFoundException extends Exception {
    public EntityNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
