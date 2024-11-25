package pe.edu.i202222219.cl1_jpa_data_diaz_luis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.entity.Country;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.entity.Countrylanguage;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.repository.CountryLanguageRepository;
import pe.edu.i202222219.cl1_jpa_data_diaz_luis.repository.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataDiazLuisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataDiazLuisApplication.class, args);
	}

	@Autowired
	private CountryLanguageRepository countryLanguageRepository;

//
//	@Override
//	public void run(String... args) throws Exception {
//		// Obtener los lenguajes hablados en el país "ARG" (Argentina)
//		List<Countrylanguage> argLanguages = countryLanguageRepository.findByCountryCode("ARG");
//
//		// Usar ifPresentOrElse para manejar la lógica
//		Optional.ofNullable(argLanguages)
//				.filter(languages -> !languages.isEmpty()) // Filtrar si la lista no está vacía
//				.ifPresentOrElse(
//						// Si se encuentran lenguajes para ARG, imprimirlos
//						languages -> {
//							System.out.println("Lenguajes en Argentina (ARG):");
//							languages.forEach(language -> System.out.println(language.getLanguage()));
//						},
//						// Si no se encuentran lenguajes en ARG, buscar para PER (Perú)
//						() -> {
//							List<Countrylanguage> perLanguages = countryLanguageRepository.findByCountryCode("PER");
//							if (!perLanguages.isEmpty()) {
//								System.out.println("Lenguajes en Perú (PER):");
//								perLanguages.forEach(language -> System.out.println(language.getLanguage()));
//							} else {
//								System.out.println("No se encontraron lenguajes para Argentina ni Perú.");
//							}
//						}
//				);
//	}

	@Override
	public void run(String... args) throws Exception {
		// Eliminar los países "COL" y "ARG" y sus datos asociados
		countryLanguageRepository.deleteAllById(List.of("COL", "ARG"));

		System.out.println("Países COL y ARG, junto con sus ciudades y lenguajes, han sido eliminados.");
	}
}

























