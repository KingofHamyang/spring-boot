package com.ronnie.first.demo;

import com.ronnie.first.demo.repository.UserRepository;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
//            log.info("Preloading " + repository.save(new User("Ronnie", "manager", "pass")));
//            log.info("Preloading " + repository.save(new User("Alex", "superUser", "pass2")));
        };
    }
}