package springboot.example.gameofflags.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import static java.util.regex.Pattern.compile;
import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String> {
    private static final String PASSWORD_PATTERN =
            "^[a-zA-Z0-9_+&*-]+[a-zA-Z0-9_+&*-]$";

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null){
            return false;
        }
        Pattern pattern = compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
