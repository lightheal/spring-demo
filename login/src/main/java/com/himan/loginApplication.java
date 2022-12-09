package com.himan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.himan")
@EnableJpaRepositories(basePackages = { "org.jpa.repository","com.himan" })
@EntityScan(basePackages = { "org.entity","com.himan" })
public class loginApplication {

	public static void main(String[] args) {
		SpringApplication.run(loginApplication.class, args);
	}

}
