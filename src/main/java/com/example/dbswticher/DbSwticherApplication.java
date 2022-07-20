package com.example.dbswticher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.util.Arrays;

@SpringBootApplication
public class DbSwticherApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSwticherApplication.class, args);
    }

    @Autowired
    private Environment environment;

    @EventListener
    public void handle(ApplicationStartedEvent event) {
        System.out.printf("Active profile: %s%n", Arrays.toString(environment.getActiveProfiles()));

        String[] driverClassNames = {
                "org.h2.Driver",
                "org.postgresql.Driver"
        };

        for (String driverClassName : driverClassNames) {
            try {
                Class.forName(driverClassName);
                System.out.printf("Driver [%s] is loaded%n", driverClassName);
            } catch (ClassNotFoundException e) {
                System.out.printf("Driver [%s] is missing%n", driverClassName);
            }
        }
    }
}
