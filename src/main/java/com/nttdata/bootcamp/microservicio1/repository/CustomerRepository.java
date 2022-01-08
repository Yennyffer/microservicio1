package com.nttdata.bootcamp.microservicio1.repository;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CustomerRepository 
    extends ReactiveMongoRepository<Customer,String> {

    //Flux<Customer> findCustomerByIdentityDocument_Number(String number);
    Flux<Customer> findCustomerByCustomerType_Description(String description);
}
