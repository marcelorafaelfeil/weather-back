package br.com.hbsis.test.weatherapi.exception;

import kong.unirest.Headers;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 22:23
 */
public class ApiRequestException extends Exception {
    private String host;
    private Integer status;
    private Headers headers;
    private Object body;

    public ApiRequestException(String host, Integer status) {
        super();
        this.host = host;
        this.status = status;
    }

    public ApiRequestException(String host, Integer status, Headers headers, Object body) {
        super();
        this.host = host;
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public String getMessage() {
        return "[host="+this.host+", status="+this.status+", body="+this.body+"]";
    }
}
