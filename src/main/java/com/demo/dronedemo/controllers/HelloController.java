package com.demo.dronedemo.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello/{name}")
    public ResponseEntity<Response> sayHello(@PathVariable("name") String name) {
        return ResponseEntity.ok()
                .body(new Response("Hello " + Optional.ofNullable(name).filter(v -> v.isEmpty()).orElse("world")));
    }

    @GetMapping(value = "/hello")
    public ResponseEntity<Response> sayHelloWorld() {
        return ResponseEntity.ok().body(new Response("Hello world"));
    }
}