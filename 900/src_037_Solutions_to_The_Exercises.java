// ---- File FloatRange.java
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

// ---- File FloatRangeValidator.java
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
                  (min == -Double.MAX_VALUE ? min :
                          min - precision) 
               && value.doubleValue() <= 
                  (max == Double.MAX_VALUE ? max : 
                          max + precision);
    }
}
