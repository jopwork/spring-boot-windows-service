package com.jopwork.webapp;

import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ShutdownHandler {
    private static final Logger logger = LoggerFactory.getLogger(ShutdownHandler.class);

    @PreDestroy
    public void preDestroy() throws InterruptedException {
        logger.info("Shutting down SpringApplication in 10 seconds...");
        Thread.sleep(10000);
        logger.info("Shutting down SpringApplication...");
    }
}
