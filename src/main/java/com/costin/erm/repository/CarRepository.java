package com.costin.erm.repository;

import com.costin.erm.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByOrderByName();

    @Query("SELECT c FROM Car c " +
            "WHERE c.name LIKE :theName " +
            "OR c.producer LIKE :theName")
    List<Car> searchCarsByName(@Param("theName") String theName);

}
