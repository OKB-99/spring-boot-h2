package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

  @Autowired
  private PersonService personService;

  @Autowired
  private UserService userService;

  @RequestMapping(path = "/persons")
  public Iterable<Person> findAllPersons() {
    return personService.findAll();
  }

  @RequestMapping(path = "/users")
  public Iterable<User> findAllUsers() {
    return userService.findAll();
  }
}
