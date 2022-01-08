package com.nttdata.bootcamp.microservicio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TypeDocumentIdentity {
    
    private int id;
    private String description;
    private boolean isActive;

}