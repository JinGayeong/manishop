package com.shop;

import com.shop.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


@Import(Config.class)
@SpringBootApplication
@ComponentScan(basePackages="com.shop.web")
public class ManishopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManishopApplication.class, args);
	}

/*	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}*/



}
