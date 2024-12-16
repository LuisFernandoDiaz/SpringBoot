package com.example.demo.response;

import com.example.demo.dto.CarDto;

import java.util.List;

public record GetAllCarsResponse(String code,
                                 String error,
                                 List<CarDto> cars) {
}
