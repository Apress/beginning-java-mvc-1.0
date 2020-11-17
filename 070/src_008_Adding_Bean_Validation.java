package book.javamvc.validation;

import java.util.Arrays;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringEnumValidator implements 
      ConstraintValidator<StringEnum, String> {
    private String[] val;
	
    @Override
    public void initialize(StringEnum constraint) {
    	this.val = constraint.value();
    }
 
    @Override
    public boolean isValid(String value, 
          ConstraintValidatorContext context) {
        return Arrays.asList(val).contains(value);
    }
}
