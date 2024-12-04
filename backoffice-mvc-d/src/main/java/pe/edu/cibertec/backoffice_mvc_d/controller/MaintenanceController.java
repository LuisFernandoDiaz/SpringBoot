package pe.edu.cibertec.backoffice_mvc_d.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDetailDto;
import pe.edu.cibertec.backoffice_mvc_d.dto.FilmDto;
import pe.edu.cibertec.backoffice_mvc_d.entity.Film;
import pe.edu.cibertec.backoffice_mvc_d.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/mantenimiento")
public class MaintenanceController {


    @Autowired
    MaintenanceService maintenanceService;


    @GetMapping("/listar")
    public String listar(Model model) {

        List<FilmDto> films = maintenanceService.ListarFilms();
        model.addAttribute("films", films);
        return "mantenimiento";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Integer id, Model model) {

        FilmDetailDto filmDetailDto = maintenanceService.buscarId(id);
        model.addAttribute("film", filmDetailDto);
        return "mantenimiento-detalle";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        FilmDetailDto filmDetailDto = maintenanceService.buscarId(id);
        model.addAttribute("film", filmDetailDto);
        return "mantenimiento-editar";
    }

    @PostMapping("/editar-confirm")
    public String editar(@ModelAttribute FilmDetailDto filmDetailDto, Model model) {

        maintenanceService.editarFilm(filmDetailDto);
        model.addAttribute("film", filmDetailDto);
        return "redirect:/mantenimiento/listar";
    }





    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Integer id){

        maintenanceService.eliminarFilm(id);
    }





    @GetMapping("/guardar")
    public String guardarFilm(@PathVariable Integer id, Model model){

        List<FilmDto> films = maintenanceService.ListarFilms();
        model.addAttribute("film", films);
        return "mantenimiento-guardar";
    }

    @PostMapping("/guardar-confirm")
    public String guardarFilm(@ModelAttribute Film film, Model model) {
        maintenanceService.agregarFilm(film);
        model.addAttribute("film", film);
        return "redirect:/mantenimiento/listar";  // Redirigir a la lista de films después de guardar
    }





}
