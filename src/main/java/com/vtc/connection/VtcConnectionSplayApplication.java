package com.vtc.connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.vtc"})
@Configuration
@EnableJpaRepositories(basePackages = {"com.vtc"})
@EntityScan("com.vtc.*")
@ComponentScan("com.vtc.*")
@PropertySource("classpath:application.properties")
public class VtcConnectionSplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtcConnectionSplayApplication.class, args);
	}

}
