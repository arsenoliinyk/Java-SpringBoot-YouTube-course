package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public String start() {
        return "Starting Page!" +
                "\nTo get students just search: localhost:8080/api/v1/students;" +
                "\nTo see hello page, enter in the search bar this: localhost:8080/hello;";
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }


}
