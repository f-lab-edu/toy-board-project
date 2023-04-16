package com.flab.toyboardproject.global.config;

import com.flab.toyboardproject.global.auth.context.SecurityContextPersistenceFilter;
import com.flab.toyboardproject.global.auth.filter.BasicAuthenticationFilter;
import com.flab.toyboardproject.global.auth.handler.AuthenticationFailureHandler;
import com.flab.toyboardproject.global.auth.handler.AuthenticationSuccessHandler;
import com.flab.toyboardproject.global.auth.handler.DefaultAuthenticationFailureHandler;
import com.flab.toyboardproject.global.auth.handler.DefaultAuthenticationSuccessHandler;
import com.flab.toyboardproject.global.auth.provider.AuthenticationManager;
import com.flab.toyboardproject.global.auth.provider.UserDetailsAuthenticationProvider;
import com.flab.toyboardproject.global.auth.userdetails.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AuthConfig implements WebMvcConfigurer {
    private final UserDetailsService userDetailsService;

    public AuthConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityContextPersistenceFilter());
        registry.addInterceptor(new BasicAuthenticationFilter(successHandler(), failureHandler(), userDetailsAuthenticationProvider()));
    }

    @Bean
    AuthenticationSuccessHandler successHandler() {
        return new DefaultAuthenticationSuccessHandler();
    }

    @Bean
    AuthenticationFailureHandler failureHandler() {
        return new DefaultAuthenticationFailureHandler();
    }

    @Bean
    AuthenticationManager userDetailsAuthenticationProvider() {
        return new UserDetailsAuthenticationProvider(userDetailsService);
    }
}
