package com.example.demo;

import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class DemoApplicationTest extends AbstractJUnit4SpringContextTests {

  @Test
  public void outputBean() {
    System.out.println("## Test Case 1");
    for (String bean: this.applicationContext.getBeanDefinitionNames()) {
      System.out.println("Bean: " + bean);
    }
  }

  @Test
  public void restGetRequest() {
    RestTemplate template = new RestTemplate();
    Person[] response = template.getForObject("http://localhost:8080/rest/persons", Person[].class);
    for (Person person: response) {
      System.out.println(person.toString());
    }
  }

  @Test
  public void restPostRequest() {
    RestTemplate template = new RestTemplate();
    Person person = new Person();
    person.setLastName("Dyson");
    person.setFirstName("Mike");
    person.setEmail("mike.dyson@exapmple.com");

    Person returnedPerson = template.postForObject("http://localhost:8080/rest/persons/insert", person, Person.class);
    System.out.println(returnedPerson.toString());
  }
}
