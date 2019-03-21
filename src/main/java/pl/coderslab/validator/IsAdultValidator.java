package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class IsAdultValidator implements ConstraintValidator<IsAdult, LocalDate> {

    private int age;

    @Override
    public void initialize(IsAdult isAdult) {
        age=isAdult.value();
    }

    @Override
    public boolean isValid(LocalDate currentValue, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dateToCheck = currentDate.minusYears(age);

        return currentValue.isBefore(dateToCheck);
    }
}
