package com.nttdata.bootcamp.microservicio1.expose;

import static org.mockito.Mockito.when;
import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.MediaType;
import java.util.ArrayList;
import java.util.List;

public class CustomerControllerTest {
    /*@MockBean
    private CustomerService customerService;
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private CustomerController customerController;

    private static final Customer customerMock = new Customer();
    private static final Customer customer = new Customer();
    private static final List<Customer> customerList = new ArrayList<>();
    private final static String id = "61d874f0d5569b07f40795a0_01";
    private final static String firstName = "Jose Luis";
    private final static String lastName = "Peralta";
    private final static String email = "joseluis@gmail.com";
    private final static String typeAddress = "Calle";
    private final static String nameAddress = "San Lorenzo";;
    private final static String numberAddress = "N°562" ;
    private final static String provinceAddress = "La Victoria";
    private final static String districtAddress = "La Victoria";
    private final static String departmentAddress = "Sullana";
    private final static String telephone = "9492507508";
    private final static boolean isActive = true;
    private final static String status = "ACTIVE";
    private final static String numberDocumentIdentity = "72159854";
    private final static String documentoIdentityCodigo = "1";
    private final static String documentoIdentityDescription = "DNI";
    private final static String customerTypeDescription = "PERSONAL";
    private final static String customerTypeCodigo = "1";
    private final static String customerProfileCodigo = "1";
    private final static String customerProfileDescription = "VIP";

    @BeforeAll
    static void setUp() {
        customerMock.setId(id);
        customerMock.setFirstname(firstName);
        customerMock.setLastname(lastName);
        customerMock.setEmail(email);
        customerMock.getAddress().setType(typeAddress);
        customerMock.getAddress().setName(nameAddress);
        customerMock.getAddress().setNumber(numberAddress);
        customerMock.getAddress().setProvince(provinceAddress);
        customerMock.getAddress().setDistrict(districtAddress);
        customerMock.getAddress().setDepartment(departmentAddress);
        customerMock.setTelephone(telephone);
        customerMock.setActive(isActive);
        customerMock.setStatus(status);
        customerMock.setNumberDocumentIdentity(numberDocumentIdentity);
        customerMock.getTypeDocumentIdentity().setCodigo(documentoIdentityCodigo);
        customerMock.getTypeDocumentIdentity().setDescription(documentoIdentityDescription);
        customerMock.getCustomerType().setCodigo(customerTypeCodigo);
        customerMock.getCustomerType().setDescription(customerTypeDescription);
        customerMock.getCustomerProfile().setCodigo(customerProfileCodigo);
        customerMock.getCustomerProfile().setDescription(customerProfileDescription);
        BeanUtils.copyProperties(customerMock, customer);
        customerList.add(customerMock);
    }

    @Test
    @DisplayName("GET -> /api/v1/customers/all")
    void findAll() {
        when(customerService.findAll()).thenReturn(Flux.fromIterable(customerList));
        Assertions.assertNotNull(customerController.findAll());
    }

    @Test
    @DisplayName("GET -> /api/v1/customers/numberDocumentIdentity/{numberDocumentIdentity}")
    void findByNumberDocumentIdentity() {

        when(customerService.findByNumberDocumentIdentity(numberDocumentIdentity)).thenReturn(Mono.just(customer));

        WebTestClient.ResponseSpec responseSpec = webTestClient.get().uri("/api/v1/customers/numberDocumentIdentity/" + numberDocumentIdentity)
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
        responseSpec.expectBody()
                .jsonPath("$.numberDocumentIdentity").isEqualTo(customerMock.getNumberDocumentIdentity());

    }

    @Test
    @DisplayName("DELETE -> /api/v1/customers/{id}")
    void remove() {

        when(customerService.remove(id)).thenReturn(Mono.just(customerMock));

        WebTestClient.ResponseSpec responseSpec = webTestClient.delete().uri("/api/v1/customers/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
        responseSpec.expectBody()
                .jsonPath("$.id").isEqualTo(customerMock.getId());

    }

    @Test
    @DisplayName("POST -> /api/v1/customers/")
    void save() {
        when(customerService.create(customerMock)).thenReturn(Mono.just(customerMock));
        Assertions.assertNotNull(customerController.create(customerMock));
    }*/
}
