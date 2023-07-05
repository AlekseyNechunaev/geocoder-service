package ru.nechunaev.geocoderservice.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.nechunaev.geocoderservice.validation.annotation.Longitude;

public class LongitudeValidator implements ConstraintValidator<Longitude, Double> {
    private static final int LONGITUDE_MIN_BOUND = -180;
    private static final int LONGITUDE_MAX_BOUND = 180;

    @Override
    public boolean isValid(Double latitude, ConstraintValidatorContext context) {
        return latitude >= LONGITUDE_MIN_BOUND && latitude <= LONGITUDE_MAX_BOUND;
    }
}
