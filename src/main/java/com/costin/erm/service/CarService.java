package com.costin.erm.service;


import com.costin.erm.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> findAll();

    Car findById(int theId);

    void save(Car theCar);

    void deleteById(int theId);

    List<Car> searchCars(String theName);
}
