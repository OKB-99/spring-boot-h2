package com.example.demo.service;

import com.example.demo.dto.UpdatePasswordRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Iterable<User> findAll() {
    return userRepository.findAll();
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User updatePassword(UpdatePasswordRequest updatePasswordRequest) {
    User user = userRepository.findById(updatePasswordRequest.getId()).get();
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    if (!user.getPassword().equals(passwordEncoder.encode(updatePasswordRequest.getOldPassword())))
      throw new RuntimeException("Password is NOT correct!");
    else if (updatePasswordRequest.getNewPasswordOne().equals(updatePasswordRequest.getNewPasswordTwo()))
      throw new RuntimeException("New password is Mismatched!");

    user.setPassword(passwordEncoder.encode(updatePasswordRequest.getNewPasswordOne()));
    return userRepository.save(user);
  }
}
