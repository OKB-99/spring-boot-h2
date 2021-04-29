package com.example.demo.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class GrantedAuthorityImpl implements GrantedAuthority {

  private String authority;

  @Override
  public String getAuthority() {
    return authority;
  }
}
