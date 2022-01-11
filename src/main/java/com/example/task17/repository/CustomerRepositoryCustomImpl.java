package com.example.task17.repository;

import com.example.task17.entity.Customer;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryCustomImpl implements CustomerRepositoryCustom {
    @Autowired
    private MongoTemplate mongoTemplate;

    public long updateCustomer(String customerId, String firstName, String lastName) {
        String nameOfAccount = firstName + " " + lastName;
        Query query = new Query(Criteria.where("id").is(customerId));
        Update update = new Update();
        update.set("firstName", firstName);
        update.set("lastName", lastName);
        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Customer.class);

        if (result != null) {
            return result.getModifiedCount();
        }
        return 0;
    }

    public void createCustomer(Customer customer) {
        mongoTemplate.save(customer);
    }
}