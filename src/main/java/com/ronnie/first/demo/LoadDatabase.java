package com.ronnie.first.demo;

import com.ronnie.first.demo.user.User;
import com.ronnie.first.demo.user.UserRepository;

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
            log.info("Preloading " + repository.save(new User("Ronnie", "manager")));
            log.info("Preloading " + repository.save(new User("Alex", "superUser")));
        };
    }
}