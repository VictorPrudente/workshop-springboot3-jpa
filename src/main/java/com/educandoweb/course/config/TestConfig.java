package com.educandoweb.course.config;


import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User(null, "Test Subject 01", "test01@email.com", "9191919191", "123451");
        User user2 = new User(null, "Test Subject 02", "teste02@email.com", "9292929292", "123452");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
