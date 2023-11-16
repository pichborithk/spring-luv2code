package dev.pichborith.springboot.demo.firstspringbootapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
