package com.kshitij.restIntro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration {


    @Bean
    @Scope("prototype")
    public User getUser()
    {
        return new User();
    }

}
