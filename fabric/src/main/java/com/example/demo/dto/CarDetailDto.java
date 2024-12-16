package com.example.demo.dto;

import java.util.Date;

public record CarDetailDto(

         Integer carId,
         String make,
         String model,
         Integer year,
         String licensePlate,
         String ownerName,
         String ownerContact,
         Integer mileage,
         String engineType,
         String color) {
}
