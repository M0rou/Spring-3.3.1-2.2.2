//package web.service;
//
//
//import web.model.Car;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//public class CarSerivce implements CarService {
//    public CarSerivce() {}
//
//    @Override
//    public List<Car> setDefaultCars() {
//        Car BMW = new Car(228, "BMW", "Black");
//        Car Audi = new Car(144, "Audi", "Quicksilver");
//        Car Mercedes = new Car(333, "Mercedes", "Purple");
//        Car Toyota = new Car(444, "Toyota", "Blue");
//        Car Ford = new Car(555, "Ford", "Red");
//        List<Car> cars = new ArrayList<>();
//        cars.add(BMW);
//        cars.add(Audi);
//        cars.add(Mercedes);
//        cars.add(Toyota);
//        cars.add(Ford);
//        return cars;
//    }
//
//    @Override
//    public List<Car> getSomeCars(int count, List<Car> cars) {
//        if (count < 0) return cars.stream()
//                .filter(x-> Objects.equals(x.getColor(), "none"))
//                .toList();
//        else if (count > cars.size() - 1 || count == 0) return cars;
//        else return cars.subList(0, Math.min(count, cars.size()));
//    }
//}
