package com.carchoice;

/**
 * Created by cmitchell on 4/18/17.
 */
public class Car {

    private Integer carId;
    private String carModel;
    private String carMake;
    private String carYear;


    public Car(Integer carId, String carModel, String carYear, String carMake){
        this.carId = carId;
        this.carModel = carModel;
        this.carMake = carMake;
        this.carYear = carYear;

    }

    @Override
    public String toString() {
        return "car{" +
                "carId=" + carId +
                ",carMake ='" + carMake + '\'' +
                ",carModel ='" + carModel + '\'' +
                ",carYear ='" + carYear + '\'' +
                '}';
    }
    public Car(){

    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
}
