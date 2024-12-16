package com.example.demo.service;

import com.example.demo.dto.CarDetailDto;
import com.example.demo.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> listarCar() throws  Exception;
    Optional<CarDetailDto> listarDetalleCar(int carId) throws  Exception;
    boolean modificarCar(CarDto carDto) throws Exception;
    boolean eliminarCar(int carId) throws Exception;
    boolean crearCar(CarDetailDto carDetailDto) throws Exception;
}
