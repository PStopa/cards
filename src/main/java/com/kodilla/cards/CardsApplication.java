package com.kodilla.cards;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.repository.CardsRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableDiscoveryClient
public class CardsApplication {

	@Autowired
	private CardsRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			repository.save(new Card(1l, "12345678912", "debit", 1l));
			repository.save(new Card(2l, "98765432109", "credit", 1l));
		};
	}
}
