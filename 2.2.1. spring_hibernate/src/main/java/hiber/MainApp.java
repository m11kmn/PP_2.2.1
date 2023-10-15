package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("Lada", 123)));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru", new Car("BMW", 543)));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("Ford", 623)));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("Honda", 724)));

      userService.getListUsers().forEach(System.out::println);
      carService.getUserByCar("Ford", 623).forEach(System.out::println);

      context.close();
   }
}
