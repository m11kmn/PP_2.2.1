package hiber.service;

import hiber.model.User;

import java.util.List;

public interface CarService {
    public List<User> getUserByCar(String model, int series);
}
