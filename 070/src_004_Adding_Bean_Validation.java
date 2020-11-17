package book.javamvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Constraint(validatedBy = FloatRangeValidator.class)
@Target({ PARAMETER, FIELD })
@Retention(RUNTIME)
public @interface FloatRange {
    String message() default 
        "Value out of range [{min},{max}]";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String[] value() default { };
    double min() default -Double.MAX_VALUE;
    double max() default Double.MAX_VALUE;
    double precision() default 0.0;
}
