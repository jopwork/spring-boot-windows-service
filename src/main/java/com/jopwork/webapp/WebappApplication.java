package com.jopwork.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static java.lang.System.out;

@SpringBootApplication
public class WebappApplication {
    private static ConfigurableApplicationContext context = null;

    public static void main(String[] args) {

        String command = "start";
        if (args.length > 0) {
            command = args[0];
        }

        long processId = ProcessHandle.current().pid();

        switch (command) {
            case "start":
                out.printf("PID %s: Starting the application...%n", processId);
                context = SpringApplication.run(WebappApplication.class, args);
                out.printf("PID %s: The Spring Application has started. Context: %s%n", processId, context.toString());
                break;
            case "stop":
                out.printf("PID %s: Stopping the application..., Context: %s%n", processId, context == null ? "null" : context.toString());
                if (context != null) {
                    out.printf("PID %s: Stopping the SpringApplicationContext...%n", processId);
                    SpringApplication.exit(context, () -> 0);
                    context = null;
                }
                out.printf("PID %s: System.exit()...%n", processId);
                System.exit(0);
                break;
            default:
                out.printf("PID %s: Invalid Command: %s%n", processId, command);
                break;
        }
    }
}