package com.qzh.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NormalController {

    @GetMapping("/normal")
    public String sayHello() {
        return "normal";
    }
}
