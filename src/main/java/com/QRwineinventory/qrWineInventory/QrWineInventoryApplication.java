package com.QRwineinventory.qrWineInventory;

import com.QRwineinventory.qrWineInventory.models.User;
import com.QRwineinventory.qrWineInventory.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class QrWineInventoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(QrWineInventoryApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(UserRepository users, PasswordEncoder encoder) {
//		return args -> {
//			users.save(new User("user",encoder.encode("password"), true, "ROLE_USER", ""));
//			users.save(new User("admin",encoder.encode("password"), true,"ROLE_USER,ROLE_ADMIN", ""));
//		};
//	}
}
