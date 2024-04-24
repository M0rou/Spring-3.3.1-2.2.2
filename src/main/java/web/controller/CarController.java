package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImp;


@Controller
public class CarController {
    @GetMapping(value = "/cars")
    public String cars(@RequestParam(name = "count", required = false, defaultValue = "0") int count, Model model) {
        model.addAttribute("cars", new CarServiceImp().getSomeCars(count, new CarServiceImp().setDefaultCars()));
        return "cars";
    }

}
