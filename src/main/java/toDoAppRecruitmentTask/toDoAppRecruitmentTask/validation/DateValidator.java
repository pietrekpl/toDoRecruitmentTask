package toDoAppRecruitmentTask.toDoAppRecruitmentTask.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class DateValidator implements ConstraintValidator<NoBackwardsDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate deadline, ConstraintValidatorContext constraintValidatorContext) {
        return (deadline.isEqual(LocalDate.now()) || deadline.isAfter(LocalDate.now()));
    }
}
