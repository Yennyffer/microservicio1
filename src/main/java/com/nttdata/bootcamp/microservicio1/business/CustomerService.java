package com.nttdata.bootcamp.microservicio1.business;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerService}<br/>
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

public interface CustomerService {

    Mono<Customer> create(Customer customer);
  
    Mono<Customer> findById(String customerId);
  
    Flux<Customer> findAll();
  
    Mono<Customer> update(Customer customer);
  
    Mono<Customer> change(Customer customer);
  
    Mono<Customer> remove(String customerId);
    
    Flux<Customer> findCustomerByCustomerType_Description(String description);
  
  }
  

