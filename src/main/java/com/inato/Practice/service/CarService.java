package com.inato.Practice.service;

import com.inato.Practice.dto.CarDto;
import com.inato.Practice.entity.Car;
import com.inato.Practice.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public Car saveCar(CarDto carDto) {
        Car car = new Car();
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setColor(carDto.getColor());
        car.setEngine(carDto.getEngine());

        return carRepo.save(car);
    }

    public List<Car> getCars() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        Optional<Car> car = carRepo.findById(id);
        return car.orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Car updateCar(Long id, CarDto carDto) {
        Car car = getCarById(id);
        car.setMake(carDto.getMake());
        car.setModel(carDto.getModel());
        car.setYear(carDto.getYear());
        car.setColor(carDto.getColor());
        car.setEngine(carDto.getEngine());

        return carRepo.save(car);
    }

    public String deleteCar(Long id){
        Car car = getCarById(id);
        if(car == null){
            throw new RuntimeException("Cannot find");
        }
        carRepo.deleteById(id);
        return "Car deleted";
    }
}
