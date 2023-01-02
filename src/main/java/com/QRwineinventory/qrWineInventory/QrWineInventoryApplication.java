package com.QRwineinventory.qrWineInventory;

import com.QRwineinventory.qrWineInventory.models.User;
import com.QRwineinventory.qrWineInventory.models.Wine;
import com.QRwineinventory.qrWineInventory.repositories.UserRepository;
import com.QRwineinventory.qrWineInventory.repositories.WineRepository;
import com.QRwineinventory.qrWineInventory.services.WineService;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class QrWineInventoryApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(QrWineInventoryApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(WineService wineService, WineRepository wines, UserRepository users, PasswordEncoder encoder) {
		return args -> {
			if (users.findByUserName("user").isEmpty()) {
				users.save(new User("user", encoder.encode("userpass"), true, "ROLE_USER", ""));
				users.save(new User("admin", encoder.encode("adminpass"), true, "ROLE_USER,ROLE_ADMIN", ""));
			}
			if (wines.findWineByBrand("Aurore") == null) {
				UUID uid;
				Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
				hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

				// Wine 1
				uid = UUID.randomUUID();
				wineService.createQR("http://localhost:8080/inventory/wine?id="+uid, "QR-"+ uid +".png", "UTF-8", hashMap, 200, 200);
				wines.save(new Wine(uid, "Aurore", "Fautor", "2019", 16.5, "red", "dry", 13.5, 40, "QR-"+ uid +".png"));

				// Wine 2
				uid = UUID.randomUUID();
				wineService.createQR("http://localhost:8080/inventory/wine?id="+uid, "QR-"+ uid +".png", "UTF-8", hashMap, 200, 200);
				wines.save(new Wine(uid, "Ice Wine", "Asconi", "2018", 20.5, "Orange", "Half dry", 14.5, 12, "QR-"+ uid +".png"));

				// Wine 3
				uid = UUID.randomUUID();
				wineService.createQR("http://localhost:8080/inventory/wine?id="+uid, "QR-"+ uid +".png", "UTF-8", hashMap, 200, 200);
				wines.save(new Wine(uid, "Lupi", "Gitana", "2017", 30.5, "Red", "Dry", 14.5, 150, "QR-"+ uid +".png"));
			}
		};
	}

	//  =====  Update QR's directory at startup  =====
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry
				.addResourceHandler("/pictures/**")
				.addResourceLocations("/pictures/")
				.addResourceLocations("classpath:/pictures/");
	}
}
