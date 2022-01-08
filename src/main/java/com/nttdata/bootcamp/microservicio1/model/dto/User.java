package com.nttdata.bootcamp.microservicio1.model.dto;

import com.nttdata.bootcamp.microservicio1.model.Address;

import lombok.Data;

@Data
public class User {
  public int id;
  public String name;
  public String username;
  public String email;
  public Address address;
  public String phone;
  public String firstName;
  
}