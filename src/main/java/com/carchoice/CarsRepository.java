package com.carchoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


/**
 * Created by cmitchell on 4/18/17.
 */
@Component
public class CarsRepository {

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

    public Car saveCar(Car car) {
        if (car.getCarId() == null) {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(con -> {
                        PreparedStatement ps = con.prepareStatement(
                                "INSERT INTO car(carmodel, carmake, caryear)" +
                                        "VALUES (?,?,?)",
                                Statement.RETURN_GENERATED_KEYS);
                        ps.setString(1, car.getCarModel());
                        ps.setString(2, car.getCarMake());
                        ps.setString(3, car.getCarYear());

                        return ps;
                    },
                    keyHolder);

            car.setCarId((Integer) keyHolder.getKeys().get("carid"));

        } else {
        // this car exists!
        // we need to update car
        jdbcTemplate.update(
                "UPDATE car " +
                        "SET " +
                        "carmodel = ?, " +
                        "carmake = ?, " +
                        "caryear = ? " +
                        "WHERE carid = ?",
                new Object[]{
                        car.getCarMake(),
                        car.getCarModel(),
                        car.getCarYear(),
                        car.getCarId()
                }
        );
    }


        return car;
    }

}
