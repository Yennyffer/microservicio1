package com.nttdata.bootcamp.microservicio1.expose;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "20000")
class CustomerControllerTest {
    @MockBean
    private CustomerService customerService;
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private CustomerController customerController;

    private static final Address address = new Address();
    private static final TypeDocumentIdentity typeDocumentIdentity = new TypeDocumentIdentity();
    private static final CustomerType customerType = new CustomerType();
    private static final CustomerProfile customerProfile = new CustomerProfile();
    private static final Customer mockCustomer = new Customer();
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

    @BeforeAll
    static void setUp() {
        log.info("Antes de la prueba");
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
    void byId() {
        log.info("--Metodo GET: Obtener un registro de clientes por ID--");
        Mockito.when(customerService.findById(id)).thenReturn(Mono.just(mockCustomer));

        webTestClient.get().uri("/api/v1/customers/" + id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findAll() {
        log.info("--Metodo GET: Obtener todos los registros de clientes--");
        Mockito.when(customerService.findAll()).thenReturn(Flux.fromIterable(customerListMock));

        Flux<Customer> c =
                webTestClient.get().uri("/api/v1/customers/all")
                .exchange()
                .expectStatus().isOk()
                .returnResult(Customer.class)
                .getResponseBody();
    }

    @Test
    void create() {
        log.info("--Metodo POST: Agregar un nuevo cliente--");
        Mockito.when(customerService.create(mockCustomer)).thenReturn(Mono.just(mockCustomer));
    }

    @Test
    void update() {
        log.info("--Metodo UPDATE: Actualizar un nuevo cliente--");
        Mockito.when(customerService.update(mockCustomer, id)).thenReturn(Mono.just(mockCustomer));
    }


    @Test
    void delete() {
        log.info("--Metodo DELETE: Eliminar un cliente por ID--");
        Mockito.when(customerService.remove(id)).thenReturn(Mono.just(mockCustomer));

        webTestClient.delete().uri("/api/v1/customers/" + id)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findOneCustomerByDni() {
        log.info("--Metodo GET: Obtener un cliente por DNI--");
        Mockito.when(customerService.findByNumberDocumentIdentity(numberDocumentIdentity)).thenReturn(Mono.just(mockCustomer));

        webTestClient.get().uri("/api/v1/customers/numberDocumentIdentity/" + numberDocumentIdentity)
                .exchange()
                .expectStatus().isOk();
    }
}