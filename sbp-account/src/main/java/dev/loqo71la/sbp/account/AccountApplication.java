package dev.loqo71la.sbp.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Implements an API to manage transaction between accounts.
 */
@SpringBootApplication
public class AccountApplication {

    /**
     * Entry point for executing a Spring Boot application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
