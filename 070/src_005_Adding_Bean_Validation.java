package book.javamvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FloatRangeValidator implements 
      ConstraintValidator<FloatRange, Number> {     
    private double min;
    private double max;
    private double precision;
	
    @Override
    public void initialize(FloatRange constraint) {
        min = constraint.min();
        max = constraint.max();
        precision = constraint.precision();
    }
 
    @Override
    public boolean isValid(Number value, 
          ConstraintValidatorContext context) {
        return value.doubleValue() >= 
          (min == -Double.MAX_VALUE ? 
               min : min - precision) 
          && value.doubleValue() <= 
          (max == Double.MAX_VALUE ? 
               max : max + precision);
    }
}
