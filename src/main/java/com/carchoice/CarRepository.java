package com.carchoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Created by cmitchell on 4/18/17.
 */
@Component
public class CarRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    public List<Car> listCars(String search) {
        return jdbcTemplate.query("SELECT * FROM car_info WHERE lower(carmodel)  like lower(?) or lower(carmake) like lower(?) limit 50",
                new Object[]{"%" + search + "%", "%" + search + "%"},
                (resultSet, i) -> new Car(
                        resultSet.getInt("carid"),
                        resultSet.getString("carmodel"),
                        resultSet.getString("caryear"),
                        resultSet.getString("carmake")
                ));

    }


    public Car getCar(Integer carId) {
        return jdbcTemplate.queryForObject("SELECT * FROM car_info WHERE carid = ?",
                new Object[]{carId},
                (resultSet, i) -> new Car(
                        resultSet.getInt("carId"),
                        resultSet.getString("carModel"),
                        resultSet.getString("carMake"),
                        resultSet.getString("carYear")



                ));
   }
}
