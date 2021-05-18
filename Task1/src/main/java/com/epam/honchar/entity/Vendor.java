package com.epam.honchar.entity;

/**
 * Class Vendor with fields <b>price</b> and <b>guaranteePeriod</b>.
 *
 * @version 1.8
 * @autor Denys Honchar
 */
public class Vendor {
    private double price;
    private int guaranteePeriod;

    public Vendor() {
    }

    public Vendor(double price, int guaranteePeriod) {
        this.price = price;
        this.guaranteePeriod = guaranteePeriod;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getGuaranteePeriod() {
        return guaranteePeriod;
    }

    public void setGuaranteePeriod(int guaranteePeriod) {
        this.guaranteePeriod = guaranteePeriod;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Vendor vendor = (Vendor) object;
        return Double.compare(vendor.price, price) == 0 && guaranteePeriod == vendor.guaranteePeriod;
    }

    @Override
    public String toString() {
        return "AutoShop{" +
                "price=" + price +
                ", guaranteePeriod=" + guaranteePeriod +
                '}';
    }
}
