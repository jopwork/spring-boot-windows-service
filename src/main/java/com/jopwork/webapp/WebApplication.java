package com.jopwork.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import static java.lang.System.out;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        String command = "start";
        if (args.length > 0) {
            command = args[0];
        }

        log("WebApplication.main() called: args=%s".formatted(String.join(";", args)));

        switch (command) {
            case "start":
                log("BEFORE SpringApplication.run()");
                SpringApplication.run(WebApplication.class, args);
                log("AFTER SpringApplication.run()");
                break;
            case "stop":
                log("Stopping the SpringApplicationContext via actuator/shutdown");
                var restTemplate = new RestTemplate();
                var headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                var entity = new HttpEntity<>(null, headers);
                restTemplate.postForObject("http://localhost:8081/actuator/shutdown", entity, String.class);
                break;
            default:
                log("Invalid Command: " + command);
                break;
        }
    }

    public static void log(String message) {
        long processId = ProcessHandle.current().pid();
        long threadId = Thread.currentThread().getId();

        out.printf("PID %s, ThreadId: %s: %s%n", processId, threadId, message);
    }
}