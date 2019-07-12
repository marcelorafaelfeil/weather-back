package br.com.hbsis.test.weatherapi.controller;

import br.com.hbsis.test.weatherapi.model.City;
import br.com.hbsis.test.weatherapi.repository.CityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 12/07/2019 01:21
 */
@Slf4j
@RestController
@RequestMapping("/api/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;

    @Cacheable("city.search")
    @GetMapping
    public ResponseEntity searchCity(String query, Integer page, Integer size) {
        try {
            log.info("Buscar cidade. [query={}, page={}, size={}]", query, page, size);

            if (page != null && size != null) {
                return ResponseEntity.ok(this.cityRepository.findByNameContainingIgnoreCase(query, PageRequest.of(page, size)));
            } else {
                // Evita que retorne uma quantidade massiva de resultados
                if (query.length() >= 3) {
                    return ResponseEntity.ok(this.cityRepository.findByNameContainingIgnoreCase(query));
                }
            }
            return ResponseEntity.ok().body(new ArrayList<>());
        } catch (Exception e) {
            log.error("Não foi possível buscar a cidade.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
