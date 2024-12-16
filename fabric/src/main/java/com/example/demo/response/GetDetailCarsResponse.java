package com.example.demo.response;

import com.example.demo.dto.CarDetailDto;

public record GetDetailCarsResponse(String doe,
                                    String error,
                                    CarDetailDto carDetailDto) {
}
