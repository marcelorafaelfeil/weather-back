package br.com.hbsis.test.weatherapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 23:12
 */
@Data
@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private Integer id;
    private String name;
    private String country;
    private Double coordlon;
    private Double coordlat;
}
