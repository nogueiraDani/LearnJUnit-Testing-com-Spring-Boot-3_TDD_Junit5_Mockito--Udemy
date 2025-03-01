package com.dani.lessons.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dani.lessons.entity.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting generateGreeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(counter.incrementAndGet(), String.format(template, name));

    }

}
