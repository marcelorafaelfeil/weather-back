package br.com.hbsis.test.weatherapi.map;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationResponse<T> {
    private String id;
    private T value;
    private List<String> messages;

    public ValidationResponse() {
        this.messages = new ArrayList<>();
    }

    public ValidationResponse(String id) {
        this.messages = new ArrayList<>();
        this.id = id;
    }

    public ValidationResponse(String id, T value, List<String> messages) {
        this.id = id;
        this.value = value;
        this.messages = messages;
    }

    public ValidationResponse(T value, List<String> messages) {
        this.id = "1";
        this.value = value;
        this.messages = messages;
    }

    public ValidationResponse(List<String> messages) {
        this.id = "1";
        this.messages = messages;
    }

    public ValidationResponse(Enum message) {
        this.messages = new ArrayList<>();
        this.id = "1";
        this.messages.add(message.name());
    }

    public void add(Enum message) {
        this.getMessages().add(message.name());
    }

    public void add(String message) {
        this.getMessages().add(message);
    }

    public boolean isValid() {
        return (this.messages.size() == 0);
    }

    public boolean isNotValid() {
        return !this.isValid();
    }
}
