package ru.nechunaev.geocoderservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.nechunaev.geocoderservice.validation.annotation.Latitude;

public class LatitudeValidator implements ConstraintValidator<Latitude, Double> {

    private static final int LATITUDE_MIN_BOUND = -90;
    private static final int LATITUDE_MAX_BOUND = 90;

    @Override
    public boolean isValid(Double latitude, ConstraintValidatorContext context) {
        return latitude >= LATITUDE_MIN_BOUND && latitude <= LATITUDE_MAX_BOUND;
    }
}
