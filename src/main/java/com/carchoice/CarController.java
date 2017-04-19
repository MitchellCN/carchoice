package com.carchoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by cmitchell on 4/18/17.
 */
@Controller
public class CarController {

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String carlist(Model model, @RequestParam(defaultValue = "")String search){

        model.addAttribute("search", search);
        model.addAttribute("car", carRepository.listCars(search));

        return "index";
    }

    @RequestMapping("/carFacts")
    public String carFacts(Model model, Integer carId){

        if(carId ==null) {
            Car car = new Car();
            model.addAttribute("car", car);

        }else{
            model.addAttribute("car", carRepository.getCar(carId));

        }
        return "carFacts";
    }


}
