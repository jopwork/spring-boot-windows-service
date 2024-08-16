package com.jopwork.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class HelloController {
    @GetMapping("hello")
    public String hello() {
        var now = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        return "Hello, world! It is now %s.".formatted(now);
    }
}
