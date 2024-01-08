package dev.loqo71la.dev.sbp.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Implements an API to manage transaction between client.
 */
@SpringBootApplication
public class ClientApplication {

    /**
     * Entry point for executing a Spring Boot application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
}
