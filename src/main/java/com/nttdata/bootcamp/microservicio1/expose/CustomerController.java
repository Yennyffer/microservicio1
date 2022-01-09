package com.nttdata.bootcamp.microservicio1.expose;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerController}<br/>
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
 * <li>ene. 07, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@RestController
@Slf4j
public class CustomerController {

  @Autowired
  private CustomerService customerService;


  @GetMapping("/api/customers/{id}")
  public Mono<Customer> byId(@PathVariable("id") String id) {
    log.info("byId>>>>>");
    return customerService.findById(id);
  }
  
 
  @GetMapping("/api/customers-all")
  public Flux<Customer> findAll() {
    log.info("findAll>>>>>");

    return customerService.findAll();
  }
  
  @PostMapping("/api/customers/create")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Customer> create(@RequestBody Customer customer) {
    log.info("create>>>>>");
    return customerService.create(customer);
  }

  @PutMapping("/api/customers/update")
  public Mono<ResponseEntity<Customer>> update(@RequestBody Customer customer) {
    log.info("update>>>>>");
    return customerService.update(customer)
        .flatMap(customerUpdate -> Mono.just(ResponseEntity.ok(customerUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @PatchMapping("/api/customers")
  public Mono<ResponseEntity<Customer>> change(@RequestBody Customer customer) {
    log.info("change>>>>>");
    return customerService.change(customer)
        .flatMap(customerUpdate -> Mono.just(ResponseEntity.ok(customerUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/api/customers/{id}")
  public Mono<ResponseEntity<Customer>> delete(@PathVariable("id") String id) {
    log.info("delete>>>>>");
    return customerService.remove(id)
        .flatMap(customer -> Mono.just(ResponseEntity.ok(customer)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }
}
