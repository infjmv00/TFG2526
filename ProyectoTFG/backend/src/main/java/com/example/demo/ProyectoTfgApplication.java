package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Añadir esto
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // Añadir esto

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo", "controller", "service", "repository", "entity", "mapper"})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity") 
public class ProyectoTfgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProyectoTfgApplication.class, args);
    }
}