package pe.edu.i202222219.cl1_jpa_data_diaz_luis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.entity.Countrylanguage;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryLanguageRepository  extends CrudRepository<Countrylanguage,String> {


    // Método para obtener los lenguajes de un país específico
    List<Countrylanguage> findByCountryCode(String countryCode);

    // Método para obtener el primer lenguaje del país en caso de que exista
    Optional<Countrylanguage> findFirstByCountryCode(String countryCode);

    void deleteAllById(Iterable<? extends String> ids);
}
