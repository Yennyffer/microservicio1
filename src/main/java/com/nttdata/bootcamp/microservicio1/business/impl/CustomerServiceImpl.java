package com.nttdata.bootcamp.microservicio1.business.impl;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import com.nttdata.bootcamp.microservicio1.model.Address;
import com.nttdata.bootcamp.microservicio1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;


  @Override
  public Mono<Customer> create(Customer customer) {

    /*if(!customer.getId().isBlank()){
      return webClientUser.get()
      .uri(uriBuilder -> uriBuilder
          .queryParam("username", customer.getUsername())
          .build())
          .retrieve()
          .bodyToFlux(User.class)
          .next()
          .flatMap(user -> {
            Address address = new Address();
            address.setName(user.getAddress().getName());
            address.setNumber(user.getAddress().getNumber());
            address.setProvince(user.getAddress().getProvince());
            address.setDistrict(user.getAddress().getDistrict());
            address.setDepartment(user.getAddress().getDepartment());
            customer.setAddress(address);
            customer.setEmail(user.getEmail());
            customer.setFirstname(user.getFirstName());
            return customerRepository.save(customer);
          });
    }*/

    return customerRepository.save(customer);
  }

  @Override
  public Mono<Customer> findById(String customerId) {
    return customerRepository.findById(customerId);
  }

  @Override
  public Flux<Customer> findAll() {
    return customerRepository.findAll();
  }

  @Override
  public Mono<Customer> update(Customer customer) {
    return null;
  }

  @Override
  public Mono<Customer> change(Customer customer) {
    return customerRepository.findById(customer.getId())
        .flatMap(customerDB -> {
          return create(customer);
        })
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Customer> remove(String customerId) {
    return customerRepository
        .findById(customerId)
        .flatMap(p -> customerRepository.deleteById(p.getId()).thenReturn(p));

  }

}
