package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("model1", 2001, "black"));
        cars.add(new Car("model2", 2002, "white"));
        cars.add(new Car("model3", 2003, "red"));
        cars.add(new Car("model4", 2004, "green"));
        cars.add(new Car("model5", 2005, "blue"));

        List<Car> carsCount = new ArrayList<>();
        for (int i = 0; i < count; i++){
            carsCount.add(cars.get(i));
        }
        return carsCount;
    }
}
