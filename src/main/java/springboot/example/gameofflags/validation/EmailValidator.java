package springboot.example.gameofflags.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import static java.util.regex.Pattern.compile;
import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements ConstraintValidator<Email, String> {
    private static final String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null){
            return false;
        }
        Pattern pattern = compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
