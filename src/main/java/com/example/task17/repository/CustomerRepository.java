package com.example.task17.repository;

import com.example.task17.entity.Account;
import com.example.task17.entity.Address;
import com.example.task17.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    List<Customer> findByAddress(Address address);
    List<Customer> findByAccount_CardNumber(String cardNumber);
    List<Customer> findByAccount_ExpirationDateLessThan(String expirationDate);
}