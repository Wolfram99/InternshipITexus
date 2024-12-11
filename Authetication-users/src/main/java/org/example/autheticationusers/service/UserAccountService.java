package org.example.autheticationusers.service;


import org.example.autheticationusers.entity.UserAccount;
import org.example.autheticationusers.dto.JwtAuthenticationDto;
import org.example.autheticationusers.dto.UserAccountCredentialsDto;

public interface UserAccountService{
    JwtAuthenticationDto singIn(UserAccountCredentialsDto userAccountCredentialsDto);
    UserAccount findByUsername(String username);
    void insert(UserAccount user);



}
