package br.com.hbsis.test.weatherapi.service;

import br.com.hbsis.test.weatherapi.map.ValidationResponse;
import br.com.hbsis.test.weatherapi.model.SelectedCity;
import br.com.hbsis.test.weatherapi.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 12/07/2019 00:09
 */
@Service
public class ValidateCityService extends AbstractValidationService {
    @Autowired
    private CityRepository cityRepository;

    private final String INVALID_CITY = "A cidade que está tentando adicionar, é inválida.";

    public boolean existsCity(Integer id) {
        if (!this.cityRepository.existsById(id)) {
            this.validations.get(0).add(INVALID_CITY);
            return false;
        }
        return true;
    }

    public boolean isValidToInsert(SelectedCity selectedCity) {
        this.validations = new ArrayList<>();
        this.validations.add(new ValidationResponse("selected_list"));

        this.existsCity(selectedCity.getId());

        return this.isValid();
    }
}
