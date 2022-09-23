package com.costin.erm.service;

import com.costin.erm.entity.Car;
import com.costin.erm.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAllByOrderByName();
    }

    @Override
    public Car findById(int theId) {
        Optional<Car> optionalCar = carRepository.findById(theId);

        if(optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new RuntimeException("Car with id - " + theId + " not found.");
        }
    }

    @Override
    public void save(Car theCar) {
        carRepository.save(theCar);
    }

    @Override
    public void deleteById(int theId) {
        carRepository.deleteById(theId);
    }

    @Override
    public List<Car> searchCars(String theName) {
        if(theName != null && theName.trim().length() > 0) {
          return carRepository.searchCarsByName(theName);
        }
        return carRepository.findAllByOrderByName();
    }

}
