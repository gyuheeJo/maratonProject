package com.example.maratonTeam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MaratonTeamApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaratonTeamApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Value("${appName.allowedApi}")
			private String AllowedApi;
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(AllowedApi)
						.allowedMethods("*").allowCredentials(true).allowedHeaders("*");
			}
		};
	}
}
