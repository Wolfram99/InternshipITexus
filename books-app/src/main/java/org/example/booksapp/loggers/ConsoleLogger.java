package org.example.booksapp.loggers;


import org.springframework.stereotype.Component;

@Component
public class ConsoleLogger implements Logger{

    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
