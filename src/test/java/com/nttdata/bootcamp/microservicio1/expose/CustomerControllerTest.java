package com.nttdata.bootcamp.microservicio1.expose;

import com.nttdata.bootcamp.microservicio1.business.CustomerService;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


class CustomerControllerTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerController customerController;
    Customer mockCustomer = new Customer();
    private static final List<Customer> customerListMock = new ArrayList<>();
    private final static String id = "61d874f0d5569b07f40795a0_01";
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
        System.out.println("Antes de la prueba");
        mockCustomer.setId(id);
        mockCustomer.setFirstname(firstName);
        mockCustomer.setLastname(lastName);
        mockCustomer.setEmail(email);
        /*mockCustomer.getAddress().setType(typeAddress);
        mockCustomer.getAddress().setName(nameAddress);
        mockCustomer.getAddress().setNumber(numberAddress);
        mockCustomer.getAddress().setProvince(provinceAddress);
        mockCustomer.getAddress().setDistrict(districtAddress);
        mockCustomer.getAddress().setDepartment(departmentAddress);*/
        mockCustomer.setTelephone(telephone);
        mockCustomer.setActive(isActive);
        mockCustomer.setStatus(status);
        mockCustomer.setGender('M');
        mockCustomer.setDateBirth(dateBirth);
        mockCustomer.setNumberDocumentIdentity(numberDocumentIdentity);
        /*mockCustomer.getTypeDocumentIdentity().setCodigo(documentoIdentityCodigo);
        mockCustomer.getTypeDocumentIdentity().setDescription(documentoIdentityDescription);
        mockCustomer.getCustomerType().setCodigo(customerTypeCodigo);
        mockCustomer.getCustomerType().setDescription(customerTypeDescription);
        mockCustomer.getCustomerProfile().setCodigo(customerProfileCodigo);
        mockCustomer.getCustomerProfile().setDescription(customerProfileDescription);*/
        customerListMock.add(mockCustomer);
    }

    @Test
    void byId() {
        System.out.println("Metodo GET: Obtener un registro de clientes por ID");
        //Mockito.when(customerService.findById(id)).thenReturn(Mono.just(mockCustomer));
    }

    @Test
    void findAll() {
        System.out.println("Metodo GET: Obtener todos los registros de clientes:");
        //Mockito.when(customerService.findAll()).thenReturn(Flux.fromIterable(customerListMock));
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void change() {
    }

    @Test
    void delete() {
    }

    @Test
    void findOneCustomerByDni() {
    }
}