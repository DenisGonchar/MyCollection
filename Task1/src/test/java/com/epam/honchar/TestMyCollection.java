package com.epam.honchar;


import com.epam.honchar.entity.Car;
import com.epam.honchar.myCollection.MyCollection;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;

import java.util.Iterator;
import java.util.List;

public class TestMyCollection {
    private static final double PRICE = 800.55;
    private static final double PRICE1 = 400.8;
    private static final int GUARANTEE = 24;
    private static final int GUARANTEE1 = 44;
    private static final int P_PLACES = 24;
    private static final double MAX_SPEED = 300.5;
    private static final double MAX_SPEED1 = 150.5;
    private static final double CLEARANCE = 0.3;

    @Test
    public void shouldEquals() {
        Car car = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        MyCollection<Car> cars = new MyCollection<>();
        cars.add(car);
        assertTrue(cars.get(0).equals(car));
    }

    @Test
    public void shouldGetSize() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        cars.add(car);
        assertEquals(1, cars.size());
        cars.add(new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE));
        assertEquals(2, cars.size());
    }

    @Test
    public void shouldCheckIfIsEmpty() {
        MyCollection<Car> cars = new MyCollection<>();
        assertTrue(cars.isEmpty());
        cars.add(new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE));
        assertFalse(cars.isEmpty());
    }

    @Test
    public void shouldContains() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        cars.add(car);
        assertTrue(cars.contains(car));
        Car car1 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(1, car1);
        assertSame(cars.get(1), car1);
        assertTrue(cars.contains(car1));
    }

    @Test
    public void shouldAdd() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        cars.add(car);
        assertEquals(1, cars.size());
        cars.add(new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE));
        assertEquals(2, cars.size());
    }

    @Test
    public void shouldAddByIndex() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(0, car);
        cars.add(1, car2);
        assertSame(cars.get(1), car2);
        assertNotSame(cars.get(0), car2);
        assertTrue(cars.contains(car));
    }

    @Test
    public void shouldGetIndex() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(car1);
        assertSame(cars.get(0), car1);
        cars.add(0, car2);
        assertSame(cars.get(0), car2);
    }

    @Test
    public void shouldRemove() {
        List<String> cars = new MyCollection<>();
        cars.add("hello");
        cars.add("Hell");
        cars.remove("hello");
        assertEquals(1, cars.size());
        assertEquals("Hell", cars.get(0));
    }

    @Test
    public void shouldRemoveByIndex() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(0, car1);
        cars.add(1, car2);
        cars.remove(0);
        assertFalse(cars.contains(car1));
        assertSame(cars.get(0), car2);
        cars.remove(0);
        assertTrue(cars.isEmpty());
    }

    @Test
    public void shouldRemoveAll() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(car1);
        cars.add(car2);
        MyCollection<Car> cars2 = new MyCollection<>();
        Car car3 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car4 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars2.add(car3);
        cars2.add(car4);
        cars.removeAll(cars2);
        assertTrue(cars.isEmpty());
        assertEquals(2, cars2.size());
    }

    @Test
    public void shouldHasNext_BaseCase() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(car1);
        cars.add(car2);
        Iterator it = cars.iterator();
        it.next();
        assertTrue(it.hasNext());
    }

    @Test
    public void shouldHasNext() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        cars.add(car1);
        Iterator it = cars.iterator();
        it.next();
        it.remove();
        assertFalse(it.hasNext());
    }

    @Test
    public void shouldNext_BaseCase() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(car1);
        cars.add(car2);
        Iterator it = cars.iterator();
        assertEquals(car1, it.next());
    }

    @Test
    public void shouldNext() {
        MyCollection<Car> cars = new MyCollection<>();
        cars.add(null);
        Iterator<Car> it = cars.iterator();
        assertNull(it.next());
    }

    @Test
    public void shouldRemove_BaseCase() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        cars.add(car1);
        Iterator<Car> it = cars.iterator();
        it.next();
        it.remove();
        assertFalse(cars.contains(car1));
        assertTrue(cars.isEmpty());
    }

    @Test
    public void shouldRemove_With2Objects() {
        MyCollection<Car> cars = new MyCollection<>();
        Car car1 = new Car(PRICE, GUARANTEE, P_PLACES, MAX_SPEED, CLEARANCE);
        Car car2 = new Car(PRICE1, GUARANTEE1, P_PLACES, MAX_SPEED1, CLEARANCE);
        cars.add(car1);
        cars.add(car2);
        Iterator<Car> it = cars.iterator();
        it.next();
        it.remove();
        assertFalse(cars.contains(car1));
        assertTrue(cars.contains(car2));
    }


}