package com.nttdata.bootcamp.microservicio1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerKafka {
    private String numberDocumentIdentity;
    private String id;
    private String firstname;
}
