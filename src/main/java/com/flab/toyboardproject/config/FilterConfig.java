package com.flab.toyboardproject.config;

import com.flab.toyboardproject.filter.LoginCheckFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

//    @Bean
//    public FilterRegistrationBean<Filter> loginCheckFilter() {
//        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
//
//        bean.setFilter(new LoginCheckFilter());
//        bean.setOrder(1);
//        bean.addUrlPatterns("/*");
//
//        return bean;
//    }

}
