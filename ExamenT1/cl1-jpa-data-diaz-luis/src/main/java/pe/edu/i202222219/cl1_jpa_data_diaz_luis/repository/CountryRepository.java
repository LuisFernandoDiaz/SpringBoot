package pe.edu.i202222219.cl1_jpa_data_diaz_luis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country,String> {
}
