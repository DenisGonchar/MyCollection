package com.epam.honchar.entity;

/**
 * Class RacingCar with fields <b>enginePower</b> and <b>accelerationTime</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class RacingCar extends Car {
    private double enginePower;
    private double accelerationTime;

    public RacingCar() {
    }

    public RacingCar(double price, int guaranteePeriod, int personPlaces, double maxSpeed, double clearance, double enginePower, double accelerationTime) {
        super(price, guaranteePeriod, personPlaces, maxSpeed, clearance);
        this.enginePower = enginePower;
        this.accelerationTime = accelerationTime;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
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
        RacingCar racingCar = (RacingCar) object;
        return Double.compare(racingCar.enginePower, enginePower) == 0 && Double.compare(racingCar.accelerationTime, accelerationTime) == 0;
    }

    @Override
    public String toString() {
        return "RacingCar{" +
                "enginePower=" + enginePower +
                ", accelerationTime=" + accelerationTime +
                '}' + super.toString();
    }
}
