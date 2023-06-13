package com.buchonsi.recipebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class RecipeBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBookApplication.class, args);
	}

}
