package net.sasconsul.caryparking.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("convertible")
public class ConvertibleCar extends Car {
    private boolean roofUp = true;

    public ConvertibleCar() {
        super();
    }

    public ConvertibleCar(String name, Integer numberOfSeats, Long productionNumber, Engine engine) {
        super(name, numberOfSeats, productionNumber, engine);
    }

    public void moveRoofUp() {
        if (!roofUp) {
            roofUp = true;
            System.out.println("The roof is now UP for " + getName());
        }
    }

    public void moveRoofDown() {
        if (roofUp) {
            roofUp = false;
            System.out.println("The roof is now DOWN for " + getName());
        }
    }

    public boolean isRoofUp() {
        return roofUp;
    }
}
