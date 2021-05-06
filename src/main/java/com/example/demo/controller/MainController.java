package com.example.demo.controller;

import com.example.demo.dto.UpdatePasswordRequest;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/demo")
public class MainController {

  @Autowired
  private UserService userService;

  @Autowired
  private PersonService personService;

  @GetMapping({"/", "/index"})
  public String index(Model model) {
    model.addAttribute("userRole", getUserRole());
    return "index";
  }

  @GetMapping("/home")
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public String home(Model model) {
    model.addAttribute("userRole", getUserRole());
    switch ((String) model.getAttribute("userRole")) {
      case "ROLE_ADMIN":
        model.addAttribute("users", userService.findAll());
      case "ROLE_USER":
        model.addAttribute("persons", personService.findAll());
        break;
    }
    return "userhome";
  }

  @PostMapping("/person/insert")
  @Secured("ROLE_ADMIN")
  public String personInsert(@RequestBody Person person) {
    personService.save(person);
    return "redirect:/demo/home";
  }

  @PostMapping("/user/updatePassword")
  @Secured({"ROLE_ADMIN", "ROLE_USER"})
  public String updatePassword(@RequestBody UpdatePasswordRequest updatePasswordRequest) {
    userService.updatePassword(updatePasswordRequest);
    return "redirect:/demo/home";
  }

  @PostMapping("/user/insert")
  @Secured("ROLE_ADMIN")
  public String userInsert(@RequestBody User user) {
    userService.save(user);
    return "redirect:/demo/home";
  }

  private String getUserRole() {
    return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
        .stream().map(auth -> auth.getAuthority()).collect(Collectors.toList()).get(0);
  }
}
