package br.com.hbsis.test.weatherapi.controller;

import br.com.hbsis.test.weatherapi.model.SelectedCity;
import br.com.hbsis.test.weatherapi.repository.SelectedCityRepository;
import br.com.hbsis.test.weatherapi.service.ValidateCityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 12/07/2019 00:06
 */
@Slf4j
@RestController
@RequestMapping("/api/selectCity")
public class SelectCityController {
    @Autowired
    private ValidateCityService validateCityService;
    @Autowired
    private SelectedCityRepository selectedCityRepository;

    @PostMapping
    public ResponseEntity addCity(@RequestBody SelectedCity city) {
        try {
            log.info("Adicionar cidade. [city={}]", city);

            if (this.validateCityService.isValidToInsert(city)) {
                SelectedCity savedCity = this.selectedCityRepository.save(city);
                return ResponseEntity.ok(savedCity);
            }
            return ResponseEntity.badRequest().body(this.validateCityService.getMessages());
        } catch (Exception e) {
            log.error("Erro interno ao adicionar a cidade.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getCity(Integer page, Integer size) {
        try {
            log.info("Listar cidade cadastadas. [page={}, size={}]", page, size);
            if (page != null && size != null) {
                return ResponseEntity.ok(
                        this.selectedCityRepository.findByOrderByNameAsc(PageRequest.of(page, size))
                );
            }
            return ResponseEntity.ok(
                    this.selectedCityRepository.findByOrderByNameAsc()
            );
        } catch (Exception e) {
            log.error("Erro interno ao retornar as cidade cadastradas.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity removeCity(@RequestBody SelectedCity city) {
        try {
            log.info("Remover cidade [city={}]", city);
            if (this.selectedCityRepository.existsById(city.getId())) {
                SelectedCity removedCity = this.selectedCityRepository.findById(city.getId()).orElse(new SelectedCity());
                this.selectedCityRepository.delete(city);
                return ResponseEntity.ok(removedCity);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            log.error("Erro interno ao remover cidade.", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
