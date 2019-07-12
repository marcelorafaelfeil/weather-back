package br.com.hbsis.test.weatherapi.service;

import br.com.hbsis.test.weatherapi.config.OpenWeatherApiProperties;
import br.com.hbsis.test.weatherapi.exception.ApiRequestException;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:01
 */
@Slf4j
@Service
public class OpenWeatherService {
    @Autowired
    private OpenWeatherApiProperties openProperties;

    public String getOpenWeatherForecast(Integer id) throws ApiRequestException {
        log.info("Enviando requisição para OpenWeather [id={}, cnt={}, lang={}, units={}, apikey={}]: {}",
                id,
                openProperties.getForecast().getCnt(),
                openProperties.getLang(),
                openProperties.getUnits(),
                openProperties.getKey(),
                openProperties.getApi().getForecast()
        );
        HttpResponse<String> result = Unirest.get(this.openProperties.getApi().getForecast())
                .queryString("id", id)
                .queryString("cnt", openProperties.getForecast().getCnt())
                .queryString("lang", openProperties.getLang())
                .queryString("units", openProperties.getUnits())
                .queryString("apikey", this.openProperties.getKey())
                .asString();

        if (result.getStatus() == HttpStatus.OK.value()) {
            byte[] byteBuffer = result.getBody().getBytes(StandardCharsets.UTF_8);
            return new String(byteBuffer, StandardCharsets.ISO_8859_1);
        } else {
            log.error("Erro interno ao enviar requisição para o OpenWeather. {}", result.getBody());
            throw new ApiRequestException(this.openProperties.getApi().getForecast(), result.getStatus(),
                    result.getHeaders(),
                    result.getBody());
        }
    }
}
