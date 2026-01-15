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
    private final String name;
    private final Integer numberOfSeats;
    private final Long productionNumber;
    private final Double horsepower;
    private final Double mpg;
    private final Boolean convertible;
    private final ParkingLot parkingLot;

    /**
     *
     */
    public CarDto(String name, Integer numberOfSeats, Long productionNumber,
                  Double horsepower, Double mpg, Boolean convertible,
                  ParkingLot parkingLot) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.productionNumber = productionNumber;
        this.horsepower = horsepower;
        this.mpg = mpg;
        this.convertible = convertible;
        this.parkingLot = parkingLot;
    }

    public String name() {
        return name;
    }

    public Integer numberOfSeats() {
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
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.numberOfSeats, that.numberOfSeats) &&
                Objects.equals(this.productionNumber, that.productionNumber) &&
                Objects.equals(this.horsepower, that.horsepower) &&
                Objects.equals(this.mpg, that.mpg) &&
                Objects.equals(this.convertible, that.convertible) &&
                Objects.equals(this.parkingLot, that.parkingLot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfSeats, productionNumber, horsepower, mpg, convertible, parkingLot);
    }

    @Override
    public String toString() {
        return "CarDto[" +
                "name=" + name + ", " +
                "numberOfSeats=" + numberOfSeats + ", " +
                "productionNumber=" + productionNumber + ", " +
                "horsepower=" + horsepower + ", " +
                "mpg=" + mpg + ", " +
                "convertible=" + convertible + ", " +
                "parkingLot=" + parkingLot + ']';
    }
}
