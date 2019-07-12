package br.com.hbsis.test.weatherapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 23:12
 */
@Data
@Entity
@Table(name = "selected_city")
@NoArgsConstructor
@AllArgsConstructor
public class SelectedCity {
    @Id
    private Integer id;
    private String name;
    private String country;
}
