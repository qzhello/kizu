package com.qzh.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 配置请求地址的权限
                .authorizeRequests()
                // 所有用户可访问
                .antMatchers("/", "/health", "/csrf-token")
                .permitAll()
                // 需要 ADMIN 角色
                .antMatchers("/admin").hasRole("ADMIN")
                // 需要 NORMAL 角色
                .antMatchers("/normal").hasAnyRole("NORMAL", "ADMIN")
                // 任何请求，访问的用户都需要经过认证
                .anyRequest().authenticated()
                .and()
                // 设置 Form 表单登陆
                .formLogin()
                // 登陆 URL 地址
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                // .defaultSuccessUrl("/hello", true)
                .failureUrl("/login.html?error=true")
                // 所有用户可访问
                .permitAll()
                .and()
                // 配置退出相关
                .logout()
                .logoutUrl("/logout")
                // 登出成功后的重定向URL
                .logoutSuccessUrl("/login.html?logout=true")
                // 使当前HTTP会话无效
                .invalidateHttpSession(true)
                // 清除身份验证信息
                .clearAuthentication(true)
                // 所有用户可访问
                .permitAll()
                .and().cors().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                // 使用内存中的 InMemoryUserDetailsManager
                .inMemoryAuthentication()
                // 不使用 PasswordEncoder 密码编码器
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                // 配置 admin 用户
                .withUser("admin").password("admin").roles("ADMIN")
                // 配置 normal 用户
                .and()
                .withUser("normal").password("normal").roles("NORMAL");
    }
}
