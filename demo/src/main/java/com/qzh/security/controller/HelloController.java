package com.qzh.security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(CsrfToken token, HttpServletRequest request) {
        return "Hello";
    }
}
