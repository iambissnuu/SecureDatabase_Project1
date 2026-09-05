package jar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import jar.entity.User;
import jar.repository.UserRepository;

@SpringBootApplication
public class SecuredatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecuredatabaseApplication.class, args);
    }

    // Add one test user when the application starts
    @Bean
    CommandLineRunner createTestUser(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByUsername("student1").isEmpty()) {

                User user = new User(
                    "student1",
                    passwordEncoder.encode("Password123!")
                );

                userRepository.save(user);

                System.out.println("Test user added to database.");
            }
        };
    }
}