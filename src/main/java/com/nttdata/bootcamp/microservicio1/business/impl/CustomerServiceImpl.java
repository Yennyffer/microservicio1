package com.nttdata.bootcamp.microservicio1.business.impl;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import com.nttdata.bootcamp.microservicio1.model.dto.CustomerDto;
import com.nttdata.bootcamp.microservicio1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerServiceImpl}<br/>
 * <b>Copyright</b>: &Copy; 2022 NTT DATA SAC. <br/>
 * <b>Company</b>: NTT DATA SAC. <br/>
 *
 * @author Yennyffer Lizana <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (EVE)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 06, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  

  @Override
  public Mono<Customer> create(Customer customer) {
	customer.setHttpStatus(HttpStatus.OK);
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
    return customerRepository.save(customer);
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
  
  @Override
  public Flux<Customer> findCustomerByCustomerType_Description(String description) {
    return customerRepository.findCustomerByCustomerType_Description(description);
  }

}
