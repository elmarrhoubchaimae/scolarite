package com.ensias.scolarite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.ensias.scolarite")
public class ScolariteApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScolariteApplication.class, args);
    }
}