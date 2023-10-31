package com.educandoweb.course.config;


import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category category1 = new Category(null, "Electronics");
        Category category2 = new Category(null, "Books");
        Category category3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(category1, category2, category3));

        User user1 = new User(null, "Test Subject 01", "test01@email.com", "9191919191", "123451");
        User user2 = new User(null, "Test Subject 02", "teste02@email.com", "9292929292", "123452");

        userRepository.saveAll(Arrays.asList(user1, user2));

        Order order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        Order order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.DELIVERED, user2);
        Order order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.PAID, user1);

        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

    }
}
