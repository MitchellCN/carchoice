package com.carchoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

/**
 * Created by cmitchell on 4/18/17.
 */
@Controller
public class CarController {

    @Autowired
    CarsRepository carsRepository;

    @RequestMapping("/")
    public String carlist(Model model, @RequestParam(defaultValue = "") String search) {

        model.addAttribute("search", search);
        model.addAttribute("cars", carsRepository.listCars(search));

        return "index";
    }

    @RequestMapping("/carFacts")
    public String carFacts(Model model, Integer carId) {

        if (carId == null) {
            Car car = new Car();
            model.addAttribute("car", car);

        } else {
            model.addAttribute("car", carsRepository.getCar(carId));

        }
        return "carFacts";
    }

    @RequestMapping("/carHonda")
    public String carHonda(Model model, Integer carId) {

        if (carId == null) {
            Car car = new Car();
            model.addAttribute("car", car);

        } else {
            model.addAttribute("car", carsRepository.getCar(carId));

        }
        return "carHonda";
    }

    @PostMapping("/saveCar")
    public String saveCar(Car car){
        carsRepository.saveCar(car);
        return "redirect:/";
    }

//    @Autowired
//    public CarQueryService carqueryservice;
//
//    @RequestMapping(path = "/")
//    public String Makes(ModelMap model) throws IOException {
//
//            model.addAttribute("makess", carqueryservice.listMakes());
//
//        return "index";
//    }
}