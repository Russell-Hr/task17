package com.example.task17.repository;

import com.example.task17.entity.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {
    long updateCustomer(String customerId, String firstName, String lastName);
    void createCustomer(Customer customer);
}
