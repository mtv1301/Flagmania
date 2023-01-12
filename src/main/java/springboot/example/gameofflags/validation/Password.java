package springboot.example.gameofflags.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Invalid representation of password. " +
            "Password must have numbers and at least one uppercase and one lowercase character.";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload() default {};
}
