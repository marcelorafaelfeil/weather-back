package br.com.hbsis.test.weatherapi.controller;

import br.com.hbsis.test.weatherapi.exception.ApiRequestException;
import br.com.hbsis.test.weatherapi.map.OpenWeatherForecastApiMap;
import br.com.hbsis.test.weatherapi.service.OpenWeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 21:48
 */
@Slf4j
@RestController
@RequestMapping("/api/openweather")
public class OpenWeatherMiddlewareController {
    @Autowired
    private OpenWeatherService openWeatherService;

    @Cacheable("openweather.forecast")
    @GetMapping("/forecast")
    public ResponseEntity getCurrentWeather(@RequestParam("id") Integer id) {
        try {
            String forecast = this.openWeatherService.getOpenWeatherForecast(id);
            return ResponseEntity.ok(forecast);
        } catch (ApiRequestException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (Exception e) {
            log.error("Erro interno ao executar método de requisição para OpenWeather", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno ao buscar previsão.");
        }
    }
}
