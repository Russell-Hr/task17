package com.example.task17.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;

@Getter
@Setter
@Document(collection="customer")
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Address address;
    private Account account;

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", account=" + account +
                '}';
    }
}
