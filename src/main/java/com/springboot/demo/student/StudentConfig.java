package com.springboot.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student parker = new Student("Peter Parker", "peter.parker@gmail.com", LocalDate.of(2000, Month.JUNE, 18));
            Student grinch = new Student("Alex Grinch", "alex.grinch@gmail.com", LocalDate.of(1999, Month.JANUARY, 11));
            Student mary = new Student("Jane Mary", "jane.mary@gmail.com", LocalDate.of(2003, Month.MARCH, 3));
            Student smith = new Student("Sam Smith", "sam.smith@gmail.com", LocalDate.of(1995, Month.OCTOBER, 25));
            repository.saveAll(List.of(parker, grinch, mary, smith));
        };
    }
}
