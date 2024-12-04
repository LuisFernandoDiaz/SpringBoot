package pe.edu.cibertec.backoffice_mvc_d.service;

import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDetailDto;
import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDto;
import pe.edu.cibertec.backoffice_mvc_d.entity.Film;

import java.util.List;

public interface MaintenanceService {

    List<FilmDto> ListarFilms();

    FilmDetailDto buscarId(int id);

    Boolean editarFilm(FilmDetailDto  filmDetailDto);

    public void eliminarFilm( Integer id);

    Film agregarFilm(Film  film);


}
