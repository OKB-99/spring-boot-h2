package com.example.demo.model;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

  @AllArgsConstructor
  public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
      return authority;
    }
  }

  private User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String role =  user.getUserRole().equals("ADMIN") ? "ROLE_ADMIN" : "ROLE_USER";
    return Arrays.asList(new GrantedAuthorityImpl(role));
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
