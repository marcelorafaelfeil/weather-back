package br.com.hbsis.test.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("br.com.hbsis.test.weatherapi.model")
@ComponentScan({
		"br.com.hbsis.test.weatherapi.controller",
		"br.com.hbsis.test.weatherapi.config",
		"br.com.hbsis.test.weatherapi.service"
})
@EnableJpaRepositories("br.com.hbsis.test.weatherapi.repository")
@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}

}
