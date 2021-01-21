package com.mongodb.starter.models;

import java.util.Objects;

public class Car {
    private String brand;
    private String model;
    private Float maxSpeedKmH;

    /**
     *
     */
    public Car() {
    }

    /**
     *
     * @return
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     * @return
     */
    public Car setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getModel() {
        return model;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    /**
     *
     * @return
     */
    public Float getMaxSpeedKmH() {
        return maxSpeedKmH;
    }

    public Car setMaxSpeedKmH(Float maxSpeedKmH) {
        this.maxSpeedKmH = maxSpeedKmH;
        return this;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", maxSpeedKmH=" + maxSpeedKmH + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(maxSpeedKmH,
                                                                                                      car.maxSpeedKmH);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(brand, model, maxSpeedKmH);
    }
}

