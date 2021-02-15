package com.javastart.hellospring;

import com.javastart.hellospring.entity.Address;
import com.javastart.hellospring.entity.Users;
import com.javastart.hellospring.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringJpaPostgresApplication {

    @Autowired
    private UsersService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaPostgresApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    private void testJpaMethods(){

        Address address = new Address();
        address.setCity("SaintP");
        address.setHomeNumber("4");
        address.setStreet("Nevskiy Prospect");

        Address address1 = new Address();
        address1.setCity("Moscow");

        Users users = new Users();
        users.setAddress(address);
        users.setEmail("someEmail@gmail.com");
        users.setName("Roman");
        userService.createUsers(users);

        Users users1 = new Users();
        users1.setName("Dima");
        users1.setEmail("gmailEmail@gmail.com");
        users1.setAddress(address1);
        userService.createUsers(users1);

        userService.findAll().forEach(it-> System.out.println(it));

        userService.findAllByName("Roman").forEach(it-> System.out.println(it));

        userService.findWhereEmailIsGmail().forEach(it-> System.out.println(it));

        userService.findWhereNameStartsFromRoman().forEach(it-> System.out.println(it));
    }
}
