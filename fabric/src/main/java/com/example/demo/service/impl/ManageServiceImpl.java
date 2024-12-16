package com.example.demo.service.impl;

import com.example.demo.dto.CarDetailDto;
import com.example.demo.dto.CarDto;
import com.example.demo.entity.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> listarCar() throws Exception {
        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCarId(),
                    car.getMake(),
                    car.getModel(),
                    car.getLicensePlate()));
        });

        return cars;
    }

    @Override
    public Optional<CarDetailDto> listarDetalleCar(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(cars -> new CarDetailDto(cars.getCarId(),
                cars.getMake(),
                cars.getModel(),
                cars.getYear(),
                cars.getLicensePlate(),
                cars.getOwnerName(),
                cars.getOwnerContact(),
                cars.getMileage(),
                cars.getEngineType(),
                cars.getColor()
                ));
    }

    @Override
    public boolean modificarCar(CarDto carDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDto.carId());
        return optional.map(cars -> {
            cars.setMake(carDto.make());
            cars.setModel(carDto.model());
            cars.setLicensePlate(carDto.licensePlate());
            carRepository.save(cars);
            return true;

        }).orElse(false);

    }

    @Override
    public boolean eliminarCar(int carId) throws Exception {
        Optional<Car> optional = carRepository.findById(carId);
        return optional.map(cars -> {
            carRepository.delete(cars);
            return true;

        }).orElse(false);
    }

    @Override
    public boolean crearCar(CarDetailDto carDetailDto) throws Exception {
        Car car = new Car();
        car.setMake(carDetailDto.make());
        car.setModel(carDetailDto.model());
        car.setYear(carDetailDto.year());
        car.setLicensePlate(carDetailDto.licensePlate());
        car.setOwnerName(carDetailDto.ownerName());
        car.setOwnerContact(carDetailDto.ownerContact());
        car.setMileage(carDetailDto.mileage());
        car.setEngineType(carDetailDto.engineType());
        car.setColor(carDetailDto.color());
        carRepository.save(car);
        return true;
    }
}
