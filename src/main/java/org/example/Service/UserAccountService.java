package org.example.Service;


import org.example.Entity.security.UserAccount;
import org.example.dto.JwtAuthenticationDto;
import org.example.dto.UserAccountCredentialsDto;

public interface UserAccountService{
    JwtAuthenticationDto singIn(UserAccountCredentialsDto userAccountCredentialsDto);
    UserAccount findByUsername(String username);
    void insert(UserAccount user);



}
