package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Persons")
@Data
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
}
