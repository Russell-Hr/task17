package com.example.task17.entity;

import lombok.*;

@Getter
@Setter
public class Account {
    private String cardNumber;
    private String nameOfAccount;
    private String expirationDate;

    @Override
    public String toString() {
        return "Account{" +
                "cardNumber='" + cardNumber + '\'' +
                ", nameOfAccount='" + nameOfAccount + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
