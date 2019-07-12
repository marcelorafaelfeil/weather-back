package br.com.hbsis.test.weatherapi.map;

import lombok.Data;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:09
 */
@Data
public class OpenWeatherTempMap {
    private Integer dt;
    private Float day;
    private Float min;
    private Float max;
    private Float night;
    private Float eve;
    private Float morn;
}
