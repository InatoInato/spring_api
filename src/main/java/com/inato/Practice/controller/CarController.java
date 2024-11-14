package com.inato.Practice.controller;

import com.inato.Practice.dto.CarDto;
import com.inato.Practice.entity.Car;
import com.inato.Practice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        try {
            List<Car> cars = carService.getCars();
            return ResponseEntity.ok(cars);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        try {
            Car car = carService.getCarById(id);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<Car> saveCar(@RequestBody CarDto carDto) {
        try {
            Car car = carService.saveCar(carDto);
            return ResponseEntity.status(201).body(car);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable("id") Long id, @RequestBody CarDto carDto) {
        try {
            Car car = carService.updateCar(id, carDto);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable("id") Long id){
        try{
            String res = carService.deleteCar(id);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
