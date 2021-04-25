package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommonController {

  @Autowired
  private PersonService personService;

  @Autowired
  private UserService userService;

  @RequestMapping(path = "/")
  public String hello() {
    return "Now DemoApplication is working!";
  }

  @GetMapping(path = "/persons")
  public Iterable<Person> findAllPersons() {
    return personService.findAll();
  }

  @GetMapping(path = "/users")
  public Iterable<User> findAllUsers() {
    return userService.findAll();
  }

  @PostMapping(path = "/persons/insert")
  public String savePerson(@RequestBody Person person) {
    Person p = personService.save(person);
    return String.format("New Person [id=%d] %s %s is inserted correctly!", p.getId(), p.getFirstName(), p.getLastName());
  }

  @PostMapping(path = "/users/insert")
  public String saveUser(@RequestBody User user) {
    User u = userService.save(user);
    Person p = personService.findById(u.getPersonId());
    return String.format("New User [id=%d] %s %s is inserted correctly!", p.getId(), p.getFirstName(), p.getLastName());
  }
}
