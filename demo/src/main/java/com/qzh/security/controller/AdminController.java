package com.qzh.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/admin")
    public String sayHello() {
        return "admin";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String reset() {
        return "delete";
    }

    @GetMapping("/search")
    @PreAuthorize("hasAnyRole('ADMIN', 'NORMAL')")
    public String search() {
        return "search";
    }
}
