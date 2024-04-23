package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarSerivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class CarConctroller {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(name = "count", required = false, defaultValue = "0") int count, Model model) {
        model.addAttribute("cars", new CarSerivce().getSomeCars(count, new CarSerivce().setDefaultCars()));
        return "cars";
    }

}
