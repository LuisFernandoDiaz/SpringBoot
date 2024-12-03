package pe.edu.cibertec.backoffice_mvc_d.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDetailDto;
import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDto;
import pe.edu.cibertec.backoffice_mvc_d.entity.Film;
import pe.edu.cibertec.backoffice_mvc_d.repository.FilmRepository;
import pe.edu.cibertec.backoffice_mvc_d.service.MaintenanceService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Override
    public List<FilmDto> ListarFilms() {
        List<FilmDto> films = new ArrayList<FilmDto>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {

            FilmDto filmDto = new FilmDto(film.getFilmId(),
                    film.getTitle(),
                    film.getLanguage().getName(),
                    film.getRentalRate());
            films.add(filmDto);

        });
        return films;
    }


    @Override
    public FilmDetailDto buscarId(int id) {

        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                film -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguage().getLanguageId(),
                        film.getLanguage().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate()
                )
        ).orElse(null);
    }

    @Override
    public Boolean editarFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> optional = filmRepository.findById(filmDetailDto.filmId());
        return optional.map(film -> {
            film.setTitle(filmDetailDto.title());
            film.setDescription(filmDetailDto.description());
            film.setReleaseYear(filmDetailDto.releaseYear());
            film.setRentalDuration(filmDetailDto.rentalDuration());
            film.setRentalRate(filmDetailDto.rentalRate());
            film.setLength(filmDetailDto.length());
            film.setReplacementCost(filmDetailDto.replacementCost());
            film.setRating(filmDetailDto.rating());
            film.setSpecialFeatures(filmDetailDto.specialFeatures());
            film.setLastUpdate(new Date());
            filmRepository.save(film);
            return true;
        }).orElse(false);
    }


}
