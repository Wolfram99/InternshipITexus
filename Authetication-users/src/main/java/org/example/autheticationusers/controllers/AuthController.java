package org.example.autheticationusers.controllers;

import org.example.autheticationusers.entity.UserAccount;
import org.example.autheticationusers.service.UserAccountService;
import org.example.autheticationusers.dto.JwtAuthenticationDto;
import org.example.autheticationusers.dto.UserAccountCredentialsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthController {


    private final UserAccountService service;

    @Autowired
    public AuthController(UserAccountService service) {
        this.service = service;
    }

    @PostMapping("/registration")
    public HttpStatus createUser(@RequestBody UserAccount userAccount) {
        System.out.println(userAccount.getRoles().toString());

        service.insert(userAccount);
        return HttpStatus.OK;
    }

    @PostMapping("/sing_in")
    public ResponseEntity<JwtAuthenticationDto> singIn(@RequestBody UserAccountCredentialsDto userAccountCredentialsDto) {
        try {
            JwtAuthenticationDto jwtAuthenticationDto = service.singIn(userAccountCredentialsDto);
            return ResponseEntity.ok(jwtAuthenticationDto);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminResponse(){
        return "Admin string";
    }


}




