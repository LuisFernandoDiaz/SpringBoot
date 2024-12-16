package com.example.demo.api;

import com.example.demo.dto.CarDetailDto;
import com.example.demo.dto.CarDto;
import com.example.demo.response.*;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public GetAllCarsResponse listarCar() {
        try {
            List<CarDto> cars = manageService.listarCar();
            if (!cars.isEmpty())
                return new GetAllCarsResponse("01", null, cars);
            else
                return new GetAllCarsResponse("02", "User not found", null);


        } catch (Exception e) {
            e.printStackTrace();
            return new GetAllCarsResponse("99", "An error ocurred, please try again", null);
        }
    }


    @GetMapping("/detail")
    public GetDetailCarsResponse listarDetalleCar(@RequestParam(value = "carId", defaultValue = "0") String carId) {

        try {
            Optional<CarDetailDto> optional = manageService.listarDetalleCar(Integer.parseInt(carId));
            return optional.map(car->
                    new GetDetailCarsResponse("01", null, car)
            ).orElse(
                    new GetDetailCarsResponse("02", "Usernot found", null)
            );
        } catch (Exception e) {
        e.printStackTrace();
        return new GetDetailCarsResponse("99", "An error ocurred, please try again", null);
        }

    }

    @PutMapping("/update")
    public UpdateCarResponse modificarCar(@RequestBody CarDto carDto){

        try {
            if(manageService.modificarCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Update failed");



        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error ocurred, please try again");


        }

    }


    @DeleteMapping("/delete/{carId}")
    public DeleteCarResponse eliminarCar(@PathVariable String carId){

        try {
            if(manageService.eliminarCar(Integer.parseInt(carId)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "Update failed");



        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error ocurred, please try again");


        }

    }


    @PostMapping("/create")
    public CreateCarResponse crearCar(@RequestBody CarDetailDto carDetailDto){

        try {
            if(manageService.crearCar(carDetailDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "Update failed");



        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error ocurred, please try again");


        }

    }


}

























