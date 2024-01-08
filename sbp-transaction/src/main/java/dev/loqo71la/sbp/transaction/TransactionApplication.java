package dev.loqo71la.sbp.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Implements an API to manage transaction between transactions.
 */
@SpringBootApplication
public class TransactionApplication {

    /**
     * Entry point for executing a Spring Boot application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
}
