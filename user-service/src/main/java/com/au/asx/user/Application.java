package com.au.asx.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application configuration class to execute the service
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = {"com.au.asx.user"})
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
