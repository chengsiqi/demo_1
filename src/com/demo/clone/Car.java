package com.demo.clone;

import java.io.Serializable;

/**
 * @author csq
 * @date 2020/4/10 16:36
 * @description
 *
 * 小汽车类
 **/
public class Car implements Serializable {

    // 品牌
    private String brand;
    // 最高时速
    private int maxSpeed;

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
