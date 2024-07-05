package com.proyecto.rest.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/method")
public class TestAuthController {
    // lo mismo hecho en el la clase pero con anotaciones

    @GetMapping("/get")
    public String helloGet() {
        return "Hello World - GET";
    }

    @PostMapping("/post")
    public String helloPost() {
        return "Hello World - POST";
    }

    @PutMapping("/put")
    public String helloPut() {
        return "Hello World - PUT";
    }

    @DeleteMapping("/delete")
    public String helloDelete() {
        return "Hello World - DELETE";
    }

    @PatchMapping("/patch")
    public String helloPatch() {
        return "Hello World - PATCH";
    }
}
