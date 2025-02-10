package org.example;

import org.example.Config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AppRunner application = context.getBean("appRunner", AppRunner.class);
        application.run();
        context.close();
    }

}