package com.example.task17.controller;

import com.example.task17.entity.Account;
import com.example.task17.entity.Address;
import com.example.task17.entity.Customer;
import com.example.task17.repository.CustomerRepository;
import com.example.task17.repository.CustomerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepositoryCustom customerRepositoryCustom;
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/create")
    public List create(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("line1") String line1,
            @RequestParam("line2") String line2,
            @RequestParam("countryCode") int countryCode,
            @RequestParam("cardNumber") String cardNumber,
            @RequestParam("expirationDate") String expirationDate
    ) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setCountryCode(countryCode);
        customer.setAddress(address);
        Account account = new Account();
        account.setNameOfAccount(firstName+" "+lastName);
        account.setCardNumber(cardNumber);
        account.setExpirationDate(expirationDate);
        customer.setAccount(account);
        customerRepositoryCustom.createCustomer(customer);
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/update")
    public void update(
            @RequestParam("customerId") String customerId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        customerRepositoryCustom.updateCustomer(customerId, firstName, lastName);
        customerRepository.findById(customerId);
    }

    @GetMapping("/find-id")
    public Optional findId(
            @RequestParam("id") String id
    ) {
        System.out.println("Found user" + customerRepository.findById(id));
        return customerRepository.findById(id);
    }

    @GetMapping("/find-name")
    public List findName(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName
    ) {
        System.out.println("Found user" + customerRepository.findByFirstNameAndLastName(firstName, lastName));
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/find-address")
    public List findAddress(
            @RequestParam("line1") String line1,
            @RequestParam("line2") String line2,
            @RequestParam("countryCode") int countryCode
    ) {
        Address address = new Address();
        address.setLine1(line1);
        address.setLine2(line2);
        address.setCountryCode(countryCode);
        System.out.println("Found user" + customerRepository.findByAddress(address));
        return customerRepository.findByAddress(address);
    }

    @GetMapping("/find-card")
    public List findCard(
            @RequestParam("cardNumber") String cardNumber
    ) {
        System.out.println("Found user" + customerRepository.findByAccount_CardNumber(cardNumber));
        return customerRepository.findByAccount_CardNumber(cardNumber);
    }

    @GetMapping("/find-expired")
    public List findExpired() {
        String now = new SimpleDateFormat("yyyyMM").format(new Date());
        System.out.println("Now" + now);
        customerRepository.findByAccount_ExpirationDateLessThan(now);
        System.out.println("Found expired user" + customerRepository.findByAccount_ExpirationDateLessThan(now));
        return customerRepository.findByAccount_ExpirationDateLessThan(now);
    }
}
