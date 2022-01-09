package com.nttdata.bootcamp.microservicio1.model.dto;


import org.springframework.http.HttpStatus;
import com.nttdata.bootcamp.microservicio1.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private Customer customer;
	private HttpStatus httpStatus;
	private String message;
}
