package com.nttdata.bootcamp.microservicio1.business.impl;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.*;
import com.nttdata.bootcamp.microservicio1.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {
    @Autowired
    private CustomerService customerService;
    @MockBean
    private CustomerRepository customerRepository;

    private static final Address address = new Address();
    private static final TypeDocumentIdentity typeDocumentIdentity = new TypeDocumentIdentity();
    private static final CustomerType customerType = new CustomerType();
    private static final CustomerProfile customerProfile = new CustomerProfile();
    private static final Customer mockCustomer = new Customer();
    private static final Customer mockCustomerRemove = new Customer();
    private static final List<Customer> customerListMock = new ArrayList<>();
    private final static String id = "61d874f0dsf";
    private final static String firstName = "Jose Luis";
    private final static String lastName = "Peralta";
    private final static String email = "joseluis@gmail.com";
    private final static String typeAddress = "Calle";
    private final static String nameAddress = "San Lorenzo";
    private final static String numberAddress = "N°562" ;
    private final static String provinceAddress = "La Victoria";
    private final static String districtAddress = "La Victoria";
    private final static String departmentAddress = "Sullana";
    private final static String telephone = "9492507508";
    private final static boolean isActive = true;
    private final static String status = "ACTIVE";
    private final static char gender = 'M';
    private static final LocalDate dateBirth = LocalDate.parse("1996-01-03");
    private final static String numberDocumentIdentity = "72159854";
    private final static String documentoIdentityCodigo = "1";
    private final static String documentoIdentityDescription = "DNI";
    private final static String customerTypeDescription = "PERSONAL";
    private final static String customerTypeCodigo = "1";
    private final static String customerProfileCodigo = "1";
    private final static String customerProfileDescription = "VIP";

    @BeforeEach
    void setUp() {
        mockCustomer.setId(id);
        mockCustomer.setFirstname(firstName);
        mockCustomer.setLastname(lastName);
        mockCustomer.setEmail(email);
        address.setType(typeAddress);
        address.setName(nameAddress);
        address.setNumber(numberAddress);
        address.setProvince(provinceAddress);
        address.setDistrict(districtAddress);
        address.setDepartment(departmentAddress);
        mockCustomer.setAddress(address);
        mockCustomer.setTelephone(telephone);
        mockCustomer.setActive(isActive);
        mockCustomer.setStatus(status);
        mockCustomer.setGender(gender);
        mockCustomer.setDateBirth(dateBirth);
        mockCustomer.setNumberDocumentIdentity(numberDocumentIdentity);
        typeDocumentIdentity.setCodigo(documentoIdentityCodigo);
        typeDocumentIdentity.setDescription(documentoIdentityDescription);
        mockCustomer.setTypeDocumentIdentity(typeDocumentIdentity);
        customerType.setCodigo(customerTypeCodigo);
        customerType.setDescription(customerTypeDescription);
        mockCustomer.setCustomerType(customerType);
        customerProfile.setCodigo(customerProfileCodigo);
        customerProfile.setDescription(customerProfileDescription);
        mockCustomer.setCustomerProfile(customerProfile);
        customerListMock.add(mockCustomer);
    }

    @Test
    void create() {
        Mockito.when(customerRepository.findByNumberDocumentIdentity(numberDocumentIdentity))
                .thenReturn(Mono.just(new Customer()));
        Mockito.when(customerRepository.save(mockCustomer)).thenReturn(Mono.just(mockCustomer));
    }

    @Test
    void findById() {
        Mockito.when(customerRepository.findById(id)).thenReturn(Mono.just(mockCustomer));
        Mono<Customer> customer = customerService.findById(id);
        StepVerifier
                .create(customer)
                .verifyComplete();
    }

    @Test
    void findAll() {
        Mockito.when(customerRepository.findAll()).thenReturn(Flux.fromIterable(customerListMock));
        Flux<Customer> customer = customerService.findAll();
    }

    @Test
    void update() {
        Mockito.when(customerRepository.findById(id)).thenReturn(Mono.just(mockCustomer));
        Mockito.when(customerRepository.save(mockCustomer)).thenReturn(Mono.just(mockCustomer));
    }

    @Test
    void remove() {

        Mockito.when(customerRepository.findById(id)).thenReturn(Mono.just(mockCustomerRemove));
        Mockito.when(customerRepository.save(mockCustomerRemove)).thenReturn(Mono.just(mockCustomerRemove));
        Mono<Customer> customer = customerService.remove(id);

    }

    @Test
    void findByNumberDocumentIdentity() {
        Mockito.when(customerRepository.findByNumberDocumentIdentity(numberDocumentIdentity))
                .thenReturn(Mono.just(mockCustomer));
        Mono<Customer> customerDtoMono = customerService.findByNumberDocumentIdentity(numberDocumentIdentity);
        StepVerifier
                .create(customerDtoMono)
                .verifyComplete();
    }
}