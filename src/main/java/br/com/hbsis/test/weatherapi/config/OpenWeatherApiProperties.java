package br.com.hbsis.test.weatherapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.validation.annotation.Validated;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 21:52
 */
@Data
@Configuration
@Validated
@PropertySource({"classpath:openweather.properties"})
@ConfigurationProperties(prefix="openweather")
public class OpenWeatherApiProperties {

    private String lang;
    private String units;
    private String key;
    private Api api;
    private Forecast forecast;

    @Data
    public static class Api {
        private String forecast;
        private String current;
    }

    @Data
    public static class Forecast {
        private Integer cnt;
    }
}
