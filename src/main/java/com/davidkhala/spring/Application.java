package com.davidkhala.spring;

import com.davidkhala.spring.data.Customer;
import com.davidkhala.spring.data.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

@SpringBootApplication
@RestController
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @Bean
    public CommandLineRunner onLoad(CustomerRepository repository) {
        return (args) -> {
            PrintStream console = System.out;
            // save a few customers
            repository.save(new Customer("Jack", "Bauer"));
            repository.save(new Customer("Chloe", "O'Brian"));
            repository.save(new Customer("Kim", "Bauer"));
            repository.save(new Customer("David", "Palmer"));
            repository.save(new Customer("Michelle", "Dessler"));

            // fetch all customers

            repository.findAll().forEach(customer -> {
                console.printf(customer.toString());
            });


            // fetch an individual customer by ID
            Customer customer = repository.findById(1L);
            console.printf(customer.toString());

            // fetch customers by last name
            repository.findByLastName("Bauer").forEach(bauer -> {
                console.printf(bauer.toString());
            });
        };
    }

}
