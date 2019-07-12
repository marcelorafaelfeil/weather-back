package br.com.hbsis.test.weatherapi.map;

import lombok.Data;

import java.util.List;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:02
 */
@Data
public class OpenWeatherForecastApiMap {
    private OpenWeatherCityMap city;
    private String cod;
    private Double message;
    private Integer cnt;
    private List<Forecast> list;

    @Data
    public static class Forecast {
        private Integer dt;
        private OpenWeatherTempMap temp;
        private Float pressure;
        private Float humidity;
        private List<OpenWeatherWeatherMap> weather;
        private Float speed;
        private Integer deg;
        private Integer clouds;
    }
}
