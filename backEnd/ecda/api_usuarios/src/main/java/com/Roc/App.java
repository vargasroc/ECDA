package com.Roc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.Roc.repository")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("API de usuarios en ejecución...");
    }
}

