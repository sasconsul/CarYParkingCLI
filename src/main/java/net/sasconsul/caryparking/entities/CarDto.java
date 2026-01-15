package net.sasconsul.caryparking.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Car} entity
 */
public final class CarDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 0L;
    private final String make;
    private final String model;
    private final Long year;
    private final String color;
    private final Long numberOfSeats;
    private final Long productionNumber;
    private final Double horsepower;
    private final Double mpg;
    private final Boolean convertible;
    private final ParkingLot parkingLot;

    /**
     *
     */
    public CarDto(String make, String model, Long year, String color, Long numberOfSeats, Long productionNumber,
                  Double horsepower, Double mpg, Boolean convertible,
                  ParkingLot parkingLot) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.numberOfSeats = numberOfSeats;
        this.productionNumber = productionNumber;
        this.horsepower = horsepower;
        this.mpg = mpg;
        this.convertible = convertible;
        this.parkingLot = parkingLot;
    }

    public String make() {
        return make;
    }

    public String model() {
        return model;
    }

    public Long year() {
        return year;
    }

    public String color() {
        return color;
    }

    public Long numberOfSeats() {
        return numberOfSeats;
    }

    public Long productionNumber() {
        return productionNumber;
    }

    public Double horsepower() {
        return horsepower;
    }

    public Double mpg() {
        return mpg;
    }

    public Boolean convertible() {
        return convertible;
    }

    public ParkingLot parkingLot() {
        return parkingLot;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (CarDto) obj;
        return Objects.equals(this.make, that.make) &&
                Objects.equals(this.model, that.model) &&
                Objects.equals(this.year, that.year) &&
                Objects.equals(this.color, that.color) &&
                Objects.equals(this.numberOfSeats, that.numberOfSeats) &&
                Objects.equals(this.productionNumber, that.productionNumber) &&
                Objects.equals(this.horsepower, that.horsepower) &&
                Objects.equals(this.mpg, that.mpg) &&
                Objects.equals(this.convertible, that.convertible) &&
                Objects.equals(this.parkingLot, that.parkingLot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(make, model, year, color, numberOfSeats, productionNumber, horsepower, mpg, convertible, parkingLot);
    }

    @Override
    public String toString() {
        return "CarDto[" +
                "make=" + make + ", " +
                "model=" + model + ", " +
                "year=" + year + ", " +
                "color=" + color + ", " +
                "numberOfSeats=" + numberOfSeats + ", " +
                "productionNumber=" + productionNumber + ", " +
                "horsepower=" + horsepower + ", " +
                "mpg=" + mpg + ", " +
                "convertible=" + convertible + ", " +
                "parkingLot=" + parkingLot + ']';
    }

}
