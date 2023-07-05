package ru.nechunaev.geocoderservice.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ru.nechunaev.geocoderservice.validation.LongitudeValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LongitudeValidator.class)
@Documented
public @interface Longitude {
    String message() default "{longitude.invalid}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
