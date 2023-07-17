package dev.loqo71la.bp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Implements an API to manage transaction between client accounts.
 */
@SpringBootApplication
public class BPApplication {

    /**
     * Entry point for executing a Spring Boot application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(BPApplication.class, args);
    }
}
