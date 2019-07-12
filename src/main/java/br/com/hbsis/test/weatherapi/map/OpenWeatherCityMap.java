package br.com.hbsis.test.weatherapi.map;

import lombok.Data;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:02
 */
@Data
public class OpenWeatherCityMap {
    private Integer id;
    private String name;
    private Coord coord;
    private String country;
    private Integer population;
    private Integer timezone;

    @Data
    public static class Coord {
        private Double lon;
        private Double lat;
    }
}
