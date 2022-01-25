package com.nttdata.bootcamp.microservicio1.model.dto;


import org.springframework.http.HttpStatus;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String typeAddress;
	private String nameAddress;
	private String numberAddress;
	private String provinceAddress;
	private String districtAddress;
	private String departmentAddress;
	private String telephone;
	private boolean isActive;
	private String status;
	private LocalDate dateBirth;
	private String gender;
	private String numberDocumentIdentity;
	private String documentoIdentityCodigo;
	private String documentoIdentityDescription;
	private String customerTypeDescription;
	private String customerTypeCodigo;
	private String customerProfileCodigo;
	private String customerProfileDescription;
}
