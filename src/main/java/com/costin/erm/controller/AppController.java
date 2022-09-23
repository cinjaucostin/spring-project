package com.costin.erm.controller;

import com.costin.erm.entity.Car;
import com.costin.erm.entity.CarProfile;
import com.costin.erm.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class AppController {

    @Autowired
    private CarService carService;

    @GetMapping("/main-page")
    public String showMainPage() {
        return "main-page";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("carProfile", new CarProfile());

        return "cars/car-form";
    }

    @GetMapping("/showCar")
    public String showCar(@RequestParam("carId") int employeeId,
                               Model model) {
        Car car = carService.findById(employeeId);

        model.addAttribute("car", car);

        return "cars/car-details";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("carId") int employeeId,
                                    Model model) {
        Car car = carService.findById(employeeId);

        model.addAttribute("car", car);

        model.addAttribute("carProfile", car.getCarProfile());

        return "cars/car-form";
    }

    @PostMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car,
                                @ModelAttribute("carProfile") CarProfile carProfile) {
        car.setCarProfile(carProfile);

        carService.save(car);

        return "redirect:/cars/list";
    }

    @GetMapping("/delete")
    public String deleteCar(@RequestParam("carId") int id) {
        carService.deleteById(id);

        return "redirect:/cars/list";
    }

    @GetMapping("/list")
    public String listCars(Model model) {
        model.addAttribute("cars", carService.findAll());

        return "cars/list-cars";
    }

    @GetMapping("/search")
    public String searchCars(@RequestParam("theName") String theName,
                                  Model model) {
        model.addAttribute("cars", carService.searchCars(theName));

        return "cars/list-cars";
    }

}
