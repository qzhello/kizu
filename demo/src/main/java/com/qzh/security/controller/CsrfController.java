package com.qzh.security.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CsrfController {

    /**
     * Spring Security CSRF会针对PATCH，POST，PUT和DELETE方法进行防护。
     */
    @GetMapping("/csrf-token")
    public String getCsrfToken(CsrfToken token) {
        return token.getToken();
    }
}
