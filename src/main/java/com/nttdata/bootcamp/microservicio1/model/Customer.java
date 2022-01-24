package com.nttdata.bootcamp.microservicio1.model;

import java.time.LocalDate;
import java.util.UUID;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Customer}<br/>
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Document(collection = "customer")

public class Customer {
    @Id
    private String id = UUID.randomUUID().toString();
    private String firstname;
    private String lastname;
    private String companyName;
    private String email;
    private Address address;
    private String telephone;
    private LocalDate dateBirth;
    private char gender;
    private boolean isActive;
    private String status;
    private String numberDocumentIdentity;
    private TypeDocumentIdentity typeDocumentIdentity; 
    private CustomerType customerType;
    private HttpStatus httpStatus;
	private CustomerProfile customerProfile;
}
