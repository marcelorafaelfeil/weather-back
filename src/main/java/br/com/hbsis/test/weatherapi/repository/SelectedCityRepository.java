package br.com.hbsis.test.weatherapi.repository;

import br.com.hbsis.test.weatherapi.model.SelectedCity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Marcelo Rafael <marcelo.rafael.feil@gmail.com>
 * Created at 11/07/2019 23:19
 */
@Repository
public interface SelectedCityRepository extends JpaRepository<SelectedCity, Integer> {
    Page<SelectedCity> findByOrderByNameAsc(Pageable pageable);
    List<SelectedCity> findByOrderByNameAsc();
}
