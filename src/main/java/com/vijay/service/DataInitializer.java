package com.vijay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.vijay.entity.User;
import com.vijay.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        String defaultUsername = "admin";
        String defaultPassword = "admin123";
        String defaultRole = "ROLE_ADMIN";

        // Check if admin user already exists
        if (userRepository.findByUsername(defaultUsername).isEmpty()) {
            User admin = new User();
            admin.setUsername(defaultUsername);
            admin.setPassword(passwordEncoder.encode(defaultPassword));
            admin.setRole(defaultRole);

            userRepository.save(admin);
            System.out.println("✅ Default admin user created: username='admin', password='admin123'");
        } else {
            System.out.println("ℹ️ Admin user already exists. Skipping creation.");
        }
    }
}
