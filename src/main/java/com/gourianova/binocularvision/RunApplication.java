package com.gourianova.binocularvision;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RunApplication {

    private static UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            UserRepository userRepository) {
        return args -> {
        /*    List<User> userList = new ArrayList<>();
            userList = userRepository.findAllByIdExists();
            for(User user:userList) {
                System.out.println(user);
 
         */

            User tatiana =new User(
                    "tgour@tut.by",
                    "tgouri",
                    2);
            userRepository.save(tatiana);

        };

    }

}



