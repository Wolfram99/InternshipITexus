package org.example.booksapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BooksAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksAppApplication.class, args);
    }

}
