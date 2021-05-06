package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordRequest {

  private Long id;
  private String oldPassword;
  private String newPasswordOne;
  private String newPasswordTwo;
}
