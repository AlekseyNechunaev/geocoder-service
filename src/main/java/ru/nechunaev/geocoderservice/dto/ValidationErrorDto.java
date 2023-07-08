package ru.nechunaev.geocoderservice.dto;

public class ValidationErrorDto {
    private String fieldName;
    private String message;
    private Object invalidValue;

    public ValidationErrorDto(String fieldName, String message, Object invalidValue) {
        this.fieldName = fieldName;
        this.message = message;
        this.invalidValue = invalidValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInvalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }
}
