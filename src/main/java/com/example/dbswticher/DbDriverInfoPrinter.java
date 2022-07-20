package com.example.dbswticher;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@RequiredArgsConstructor
@Component
public class DbDriverInfoPrinter {

    private final Environment environment;

    @EventListener
    public void handle(ApplicationStartedEvent event) {
        log.info("Active profile: {}", Arrays.toString(environment.getActiveProfiles()));

        String[] driverClassNames = {
                "org.h2.Driver",
                "org.postgresql.Driver"
        };

        for (String driverClassName : driverClassNames) {
            try {
                Class.forName(driverClassName);
                log.info("Driver [{}] is loaded", driverClassName);
            } catch (ClassNotFoundException e) {
                log.warn("Driver [{}] is missing", driverClassName);
            }
        }
    }
}
