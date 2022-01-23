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
    @MockBean
    private CustomerService customerService;
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private CustomerController customerController;

    private static final Customer customerMock = new Customer();
    private static final Customer customer = new Customer();
    private static final List<Customer> customerDtoList = new ArrayList<>();
    private final static String id = "8600000075896582475";
    private final static String numberDocumentIdentity = "72159854";
    private final static String firstName = "Jose Luis";
    private final static String lastName = "Peralta";
    private final static String telephone = "9492507508";
    private final static String email = "joseluis@gmail.com";
    private final static String status = "ACTIVE";
    private final static String customerType = "PERSONAL";
    private final static String customerTypeID = "1";
    private final static String typeAddress = "Calle";
    private final static String nameAddress = "San Lorenzo";;
    private final static String numberAddress = "N°562" ;
    private final static String provinceAddress = "La Victoria";
    private final static String districtAddress = "La Victoria";
    private final static String departmentAddress = "Sullana";
    private final static String dateBirth = "12/06/1996";
    private final static String gender = "F";
    private final static boolean isActive = true;

    @BeforeAll
    static void setUp() {
        customerMock.setId(id);
        customerMock.setNumberDocumentIdentity(numberDocumentIdentity);
        customerMock.getCustomerType().setDescription(customerType);
        customerMock.getCustomerType().setCodigo(customerTypeID);
        customerMock.setFirstname(firstName);
        customerMock.setLastname(lastName);
        customerMock.getAddress().setType(typeAddress);
        customerMock.getAddress().setName(nameAddress);
        customerMock.getAddress().setNumber(numberAddress);
        customerMock.getAddress().setProvince(provinceAddress);
        customerMock.getAddress().setDistrict(districtAddress);
        customerMock.getAddress().setDepartment(departmentAddress);
        customerMock.setTelephone(telephone);

        //customerMock.setDateBirth(dateBirth);
        customerMock.setEmail(email);
        customerMock.setStatus(status);
        BeanUtils.copyProperties(customerMock, customer);
        customerDtoList.add(customerMock);
    }

    @Test
    @DisplayName("GET -> /api/v1/customers")
    void byAll() {

        when(customerService.findAll()).thenReturn(Flux.fromIterable(customerDtoList));

        WebTestClient.ResponseSpec responseSpec = webTestClient.get().uri("/api/v1/customers")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);

    }

    @Test
    @DisplayName("GET -> /api/v1/customers/{id}")
    void byId() {

        when(customerService.findById(id)).thenReturn(Mono.just(customerMock));

        WebTestClient.ResponseSpec responseSpec = webTestClient.get().uri("/api/v1/customers/" + id)
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec.expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON);
        responseSpec.expectBody()
                .jsonPath("$.firstName").isEqualTo(customerMock.getFirstname());

    }
}
