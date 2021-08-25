package com.deerflow.thspringdandd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public final static String apiUrl = "http://localhost:8080";

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
