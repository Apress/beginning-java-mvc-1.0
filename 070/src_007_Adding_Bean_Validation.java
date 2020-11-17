package book.javamvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;


@Constraint(validatedBy = StringEnumValidator.class)
@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
public @interface StringEnum {
    String message() default 
        "String '${validatedValue}' not inside {value}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] value() default { };
}
