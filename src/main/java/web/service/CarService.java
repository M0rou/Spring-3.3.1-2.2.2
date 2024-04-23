package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    List<Car> setDefaultCars();

    List<Car> getSomeCars(int count, List<Car> cars);
}
