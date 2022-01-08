package com.nttdata.bootcamp.microservicio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DocumentIdentity {
    
    private String id;
    private String number;
    private TypeDocumentIdentity typeDocumentIdentity; 
    private boolean isActive;
}
