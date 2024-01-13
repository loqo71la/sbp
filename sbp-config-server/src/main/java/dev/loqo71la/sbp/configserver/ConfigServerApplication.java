package dev.loqo71la.sbp.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Implements a service to manage all configurations.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

    /**
     * Entry point for executing a Spring Boot application.
     *
     * @param args command-line arguments.
     */
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}
