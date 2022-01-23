package com.nttdata.bootcamp.microservicio1.business.impl;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import com.nttdata.bootcamp.microservicio1.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
 * <li>{USERNAME}. (acronym) From (YEN)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 06, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;
  private static final String ESTADO_ACTIVO_CUSTOMER = "ACTIVO";
  private static final String ESTADO_INACTIVO_CUSTOMER = "INACTIVO";
  

  @Override
  public Mono<Customer> create(Customer customer) {
    log.info("--Guardar cliente--");
    return customerRepository.findByNumberDocumentIdentity(customer.getNumberDocumentIdentity())
            .switchIfEmpty(Mono.just(new Customer()))
            .filter(c -> c.getNumberDocumentIdentity() == null)
            .doOnNext(s -> {
              BeanUtils.copyProperties(customer, s);
              s.getCustomerType().setDescription(s.getCustomerType().getDescription().toUpperCase());
              s.setStatus(ESTADO_ACTIVO_CUSTOMER);
              s.setHttpStatus(HttpStatus.OK);
            })
            .flatMap(customerRepository::insert);  //Uso de Métodos de Referencia
  }

  @Override
  public Mono<Customer> findById(String customerId) {
      log.info("--Obteniendo un cliente--");
      return customerRepository.findById(customerId).switchIfEmpty(Mono.empty())
              .filter(c -> c.getStatus().equalsIgnoreCase(ESTADO_ACTIVO_CUSTOMER));
  }

  @Override
  public Flux<Customer> findAll() {

    return customerRepository.findAll();
  }

  @Override
  public Mono<Customer> update(Customer customer, String customerId) {
    log.info("--Actualizando cliente--");
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
      log.info("--Eliminacion de un cliente - Baja del cliente(estado=INACTIVO)--");
      return customerRepository.findById(customerId).switchIfEmpty(Mono.empty())
              .doOnNext(p -> p.setStatus(ESTADO_INACTIVO_CUSTOMER))
              .flatMap(customerRepository::save);

  }

  @Override
  public Mono<Customer> findByNumberDocumentIdentity(String numberDocumentIdentity) {
    log.info("--Obteniendo Cliente por Numero de Documento de Identidad--");
    return customerRepository.findByNumberDocumentIdentity(numberDocumentIdentity)
            .switchIfEmpty(Mono.empty())
            .filter(c -> c.getStatus().equalsIgnoreCase("ACTIVO"));
  }

}
