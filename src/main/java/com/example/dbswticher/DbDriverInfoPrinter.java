package com.example.dbswticher;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class DbDriverInfoPrinter {

    private final Environment environment;

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
