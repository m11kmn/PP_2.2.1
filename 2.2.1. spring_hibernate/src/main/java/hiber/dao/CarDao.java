package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface CarDao {
    public List<User> getUserByCar(String model, int series);
}
