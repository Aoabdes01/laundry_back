package com.wash.laundry_app;

import com.wash.laundry_app.users.Role;
import com.wash.laundry_app.users.User;
import com.wash.laundry_app.users.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

// TODO: Remove this class after first successful deployment and admin account creation.
@Component
@AllArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (!userRepository.existsByEmail("jalal@gmail.com")) {
            User admin = new User();
            admin.setName("Jalal");
            admin.setEmail("jalal@gmail.com");
            admin.setPassword(passwordEncoder.encode("jalal123"));
            admin.setRole(Role.admin);
            admin.setIsActive(true);
            userRepository.save(admin);
            log.info("✅ Admin user seeded: jalal@gmail.com");
        } else {
            log.info("ℹ️ Admin user already exists, skipping seed.");
        }
    }
}
