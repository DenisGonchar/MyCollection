package com.epam.honchar.entity;

/**
 * Class AgriculturalMachine with fields <b>enginePower</b> and <b>wheelRadius</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class AgriculturalMachine extends Car {
    private double enginePower;
    private double wheelRadius;

    public AgriculturalMachine() {
    }

    public AgriculturalMachine(double price, int guaranteePeriod, int personPlaces, double maxSpeed, double clearance, double enginePower, double wheelRadius) {
        super(price, guaranteePeriod, personPlaces, maxSpeed, clearance);
        this.enginePower = enginePower;
        this.wheelRadius = wheelRadius;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

    public double getWheelRadius() {
        return wheelRadius;
    }

    public void setWheelRadius(double wheelRadius) {
        this.wheelRadius = wheelRadius;
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
        AgriculturalMachine that = (AgriculturalMachine) object;
        return Double.compare(that.enginePower, enginePower) == 0 && Double.compare(that.wheelRadius, wheelRadius) == 0;
    }

    @Override
    public String toString() {
        return "AgriculturalMachine{" +
                "enginePower=" + enginePower +
                ", wheelRadius=" + wheelRadius +
                '}' + super.toString();
    }
}
