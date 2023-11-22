package com.qzh.security.config;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 可以去实现持久化(这里不用csrf)
 */
public class CsrfTokenRedisRepository implements CsrfTokenRepository {
    @Override
    public CsrfToken generateToken(HttpServletRequest httpServletRequest) {
        return null;
    }

    @Override
    public void saveToken(CsrfToken csrfToken, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    @Override
    public CsrfToken loadToken(HttpServletRequest httpServletRequest) {
        return null;
    }
}
