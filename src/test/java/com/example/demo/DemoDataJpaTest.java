package com.example.demo;

import com.example.demo.dto.UpdatePasswordRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@TestPropertySource(
    properties = {
        "spring.datasource.initialize=false",
        "spring.datasource.continue-on-error=true"
    }
)
public class DemoDataJpaTest {

  @Autowired
  private UserRepository userRepository;

  @Test
  @Sql({"classpath:db/data.sql"})
  public void testUserService() {
    Iterable<User> test = userRepository.findAll();
    UpdatePasswordRequest request = new UpdatePasswordRequest();
    User user = userRepository.findByUsername("testuser");
    Assertions.assertEquals("testuser", user.getUsername());
  }
}
