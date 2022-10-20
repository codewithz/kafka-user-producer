package com.codewithz.kafka.producer;

import com.codewithz.kafka.producer.enums.Color;
import com.codewithz.kafka.producer.enums.DesignType;
import com.codewithz.kafka.producer.enums.ProductType;
import com.codewithz.kafka.producer.enums.UserId;
import com.codewithz.kafka.producer.model.Event;
import com.codewithz.kafka.producer.model.Product;
import com.codewithz.kafka.producer.model.User;
import com.github.javafaker.Faker;


public class EventGenerator {

    private Faker faker = new Faker();

    public Event generateEvent() {
       Event event=new Event();
       event.setUser(generateRandomUser());
       event.setProduct(generateRandomObject());
      
       
       return event;
    }

    private User generateRandomUser() {
    	
    	User user=new User();
        user.setUserId(faker.options().option(UserId.class));
        user.setUsername(faker.name().lastName());
        user.setDateOfBirth(faker.date().birthday());
        
        return user;
    }

    private Product generateRandomObject() {
       Product product=new Product();
       product.setColor(faker.options().option(Color.class));
       product.setType(faker.options().option(ProductType.class));
       product.setDesignType(faker.options().option(DesignType.class));
            
        
        return product;
    }
}
