package com.inato.Practice.dto;

public class CarDto {
    String make;
    String model;
    int year;
    String color;
    double engine;

    public CarDto(String make, String model, int year, String color, double engine) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.engine = engine;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
}
