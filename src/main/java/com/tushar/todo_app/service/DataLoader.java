package com.tushar.todo_app.service;

import com.tushar.todo_app.model.User;
import com.tushar.todo_app.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    final UserRepository userRepository;
    final BCryptPasswordEncoder bCryptPasswordEncoder;

    public DataLoader(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(
                new User(null,"user1@gmail.com",bCryptPasswordEncoder.encode("user"))
        );
        userRepository.save(
                new User(null,"user2@gmail.com",bCryptPasswordEncoder.encode("user"))
        );
    }

}
