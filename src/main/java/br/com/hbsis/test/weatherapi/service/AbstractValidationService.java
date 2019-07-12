package br.com.hbsis.test.weatherapi.service;

import br.com.hbsis.test.weatherapi.map.ValidationResponse;

import java.util.List;

public abstract class AbstractValidationService {
    protected List<ValidationResponse> validations;

    public List<ValidationResponse> getMessages() {
        return this.validations;
    }

    protected boolean isValid() {
        return (this.validations.size() == 1 && this.validations.get(0).getMessages().size() == 0);
    }
}
