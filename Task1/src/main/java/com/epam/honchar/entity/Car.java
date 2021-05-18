package com.epam.honchar.entity;

/**
 * Class Car with fields <b>personPlaces</b>, <b>maxSpeed</b> and <b>clearance</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class Car extends Vendor {
    private int personPlaces;
    private double maxSpeed;
    private double clearance;

    public Car() {
    }

    public Car(double price, int guaranteePeriod, int personPlaces, double maxSpeed, double clearance) {
        super(price, guaranteePeriod);
        this.personPlaces = personPlaces;
        this.maxSpeed = maxSpeed;
        this.clearance = clearance;
    }

    public int getPersonPlaces() {
        return personPlaces;
    }

    public void setPersonPlaces(int personPlaces) {
        this.personPlaces = personPlaces;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getClearance() {
        return clearance;
    }

    public void setClearance(double clearance) {
        this.clearance = clearance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }
        Car car = (Car) object;
        return personPlaces == car.personPlaces && Double.compare(car.maxSpeed, maxSpeed) == 0 && Double.compare(car.clearance, clearance) == 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "personPlaces=" + personPlaces +
                ", maxSpeed=" + maxSpeed +
                ", clearance=" + clearance +
                "} " + super.toString();
    }
}
