package com.example.demo.helper;

import com.example.demo.model.Person;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class PersonBuilder {

  public static Person makePerson() {
    Person person = new Person();
    Faker faker = new Faker();
    Name name = faker.name();
    person.setFirstName(name.firstName());
    person.setLastName(name.lastName());
    person.setEmail(String.format("%s.%s@example.com", person.getFirstName(), person.getLastName()));
    return person;
  }
}
