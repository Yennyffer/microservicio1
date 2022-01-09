package com.nttdata.bootcamp.microservicio1.repository;

import com.nttdata.bootcamp.microservicio1.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link CustomerRepository}<br/>
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

@Repository
public interface CustomerRepository 
    extends ReactiveMongoRepository<Customer,String> {

    //Flux<Customer> findCustomerByIdentityDocument_Number(String number);
    Flux<Customer> findCustomerByCustomerType_Description(String description);
}
