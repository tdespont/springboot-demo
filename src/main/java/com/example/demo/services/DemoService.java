package com.example.demo.services;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoService {

    @GetMapping(path = "/HelloWorld", produces = {MediaType.TEXT_PLAIN_VALUE})
    String sayHelloWorld() {
        return "Hello World!";
    }

}
