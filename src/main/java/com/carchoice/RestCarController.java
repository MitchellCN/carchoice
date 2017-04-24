package com.carchoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cmitchell on 4/23/17.
 */
@RestController
public class RestCarController {
    @Autowired
    CarsRepository carRepository;

    @GetMapping("/api/cars")
    public List<Car> listCars(@RequestParam(defaultValue = "") String search) {
        return carRepository.listCars(search);
    }
}
