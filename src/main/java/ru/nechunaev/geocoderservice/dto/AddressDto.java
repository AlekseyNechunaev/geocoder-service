package ru.nechunaev.geocoderservice.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
