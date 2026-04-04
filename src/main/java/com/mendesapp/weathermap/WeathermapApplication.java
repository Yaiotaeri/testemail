package com.mendesapp.weathermap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 👈 adiciona isso aqui
public class WeathermapApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeathermapApplication.class, args);
	}
}