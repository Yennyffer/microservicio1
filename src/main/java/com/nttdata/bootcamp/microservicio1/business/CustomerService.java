package com.nttdata.bootcamp.microservicio1.business;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> create(Customer customer);
  
    Mono<Customer> findById(String customerId);
  
    Flux<Customer> findAll();
  
    Mono<Customer> update(Customer customer);
  
    Mono<Customer> change(Customer customer);
  
    Mono<Customer> remove(String customerId);
  
  }
  

