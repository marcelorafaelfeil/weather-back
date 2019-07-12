package br.com.hbsis.test.weatherapi.map;

import lombok.Data;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:09
 */
@Data
public class OpenWeatherWeatherMap {
    private Integer id;
    private String main;
    private String description;
    private String icon;
}
