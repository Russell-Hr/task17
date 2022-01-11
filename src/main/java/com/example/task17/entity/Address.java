package com.example.task17.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String line1;
    private String line2;
    private int countryCode;

    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", countryCode=" + countryCode +
                '}';
    }
}
