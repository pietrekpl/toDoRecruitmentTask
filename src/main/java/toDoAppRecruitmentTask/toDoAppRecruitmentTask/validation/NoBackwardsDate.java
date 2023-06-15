package toDoAppRecruitmentTask.toDoAppRecruitmentTask.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)
public @interface NoBackwardsDate {
    String message() default "Cannot create a task with backwards date";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
