package ru.nechunaev.geocoderservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.nechunaev.geocoderservice.dto.ErrorDto;
import ru.nechunaev.geocoderservice.dto.ValidationErrorDto;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String UNKNOWN_ERROR = "unknown error service";
    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto unknownExceptionError(Exception e) {
        log.error("unknown system error ", e);
        return new ErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), UNKNOWN_ERROR);
    }

    @ExceptionHandler(value = {YandexMapGeocoderClientException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto geocoderClientException(YandexMapGeocoderClientException e) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = {ServiceException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto serviceException(ServiceException e) {
        return new ErrorDto(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public List<ValidationErrorDto> validationException(MethodArgumentNotValidException e) {
        log.error("validation errors", e);
        return e.getFieldErrors().stream()
                .map(fieldError -> new ValidationErrorDto(fieldError.getField(),
                        fieldError.getDefaultMessage(),
                        fieldError.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
