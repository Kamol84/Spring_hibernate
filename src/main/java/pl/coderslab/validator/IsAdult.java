package pl.coderslab.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsAdultValidator.class)
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsAdult {
    int value();


    String message() default "{pl.coderslab.validator.isAdult}";


    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

