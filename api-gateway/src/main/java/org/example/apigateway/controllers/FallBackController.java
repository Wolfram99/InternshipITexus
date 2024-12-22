package org.example.apigateway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallBackController {

    @GetMapping("/appFallback")
    public ResponseEntity<String> appFallback(){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("There is a problem with the server! Try again later");
    }






}