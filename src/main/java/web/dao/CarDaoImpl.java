package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private static final List<Car> carList;
    static {
        carList = new ArrayList<>();
        carList.add(new Car("model1", "color1", 101));
        carList.add(new Car("model2", "color2", 102));
        carList.add(new Car("model3", "color3", 103));
        carList.add(new Car("model4", "color4", 104));
        carList.add(new Car("model5", "color5", 105));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCarListOnCount(Integer countCars) {
        List<Car> list = getCars();
        if (countCars == null || countCars < 0 || countCars > list.size()) {
            countCars = list.size();
        }
        return list.stream().limit(countCars).toList();
    }
}