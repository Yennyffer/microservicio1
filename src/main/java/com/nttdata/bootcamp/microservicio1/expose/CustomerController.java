package com.nttdata.bootcamp.microservicio1.expose;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.dto.CustomerKafka;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
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
 * <li>{USERNAME}. (acronym) From (YEN)</li>
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
  @Autowired
  private KafkaTemplate<String, CustomerKafka> kafkaTemplate;
  private static final String TOPIC = "Kafka01";

  @GetMapping("/api/v1/customers/public/{numberDocumentIdentity}")
  public String post (@PathVariable("numberDocumentIdentity") final String numberDocumentIdentity) {
    log.info("Envio de mensajes kafka");
    kafkaTemplate.send(TOPIC, new CustomerKafka(numberDocumentIdentity,"b0175f31-a709-437f-8d9b-96a5e10dd6cb","nombre"));
    return "Published successfully";
  }


  @GetMapping("/api/v1/customers/{id}")
  public Mono<Customer> byId(@PathVariable("id") String id) {
    log.info("B??squeda de cliente por id:", id);
    return customerService.findById(id);
  }
  
  @GetMapping("/api/v1/customers/all")
  public Flux<Customer> findAll() {
    log.info("Obtener todas los clientes.");

    return customerService.findAll();
  }
  
  @PostMapping("/api/v1/customers/")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Customer> create(@RequestBody Customer customer) {
    log.info("Creacion de un cliente");
    return customerService.create(customer);
  }

  @PutMapping("/api/v1/customers/{id}")
  public Mono<ResponseEntity<Customer>> update(@PathVariable String id, @RequestBody Customer customer) {
    log.info("Actualizacion de un cliente.>");
    return customerService.update(customer, id)
        .flatMap(customerUpdate -> Mono.just(ResponseEntity.ok(customerUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @PatchMapping("/api/v1/customers")
  public Mono<ResponseEntity<Customer>> change(@RequestBody Customer customer) {
    log.info("change>>>>>");
    return customerService.change(customer)
        .flatMap(customerUpdate -> Mono.just(ResponseEntity.ok(customerUpdate)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/api/v1/customers/{id}")
  public Mono<ResponseEntity<Customer>> delete(@PathVariable("id") String id) {
    log.info("Eliminacion de un ciente, id:", id);
    return customerService.remove(id)
        .flatMap(customer -> Mono.just(ResponseEntity.ok(customer)))
        .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @GetMapping("/api/v1/customers/numberDocumentIdentity/{numberDocumentIdentity}")
  public Mono<ResponseEntity<Customer>> findOneCustomerByDni(@PathVariable String numberDocumentIdentity) {
    return customerService.findByNumberDocumentIdentity(numberDocumentIdentity)
            .flatMap(p -> Mono.just(ResponseEntity.ok().body(p)))
            .switchIfEmpty(Mono.just(ResponseEntity.badRequest().build()));

  }
  
}
