package com.thallesdaniel.paymentsystem;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PaymentSystemApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PaymentSystemApplication.class);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);

	}

}
