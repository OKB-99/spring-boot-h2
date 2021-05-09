package com.example.demo;

import com.example.demo.controller.MainController;
import com.example.demo.model.GrantedAuthorityImpl;
import com.example.demo.model.Person;
import com.example.demo.model.User;
import com.example.demo.model.UserDetailsImpl;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.PersonService;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.example.demo.helper.PersonBuilder.makePerson;

@WebMvcTest(controllers = MainController.class)
public class DemoWebMvcTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PersonService personService;

  @MockBean
  private UserService userService;

  @MockBean
  private UserRepository userRepository;

  @Test
  public void testMainController() throws Exception {
    List<Person> persons = Arrays.asList(makePerson(), makePerson(), makePerson());
    Mockito.when(personService.findAll()).thenReturn(persons);

    mockMvc.perform(MockMvcRequestBuilders.get("/demo/index").accept(MediaType.TEXT_HTML))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("index"));
  }
}
