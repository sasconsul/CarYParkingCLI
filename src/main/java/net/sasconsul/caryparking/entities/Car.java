package net.sasconsul.caryparking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_type")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer numberOfSeats;

    private Double currentSpeed = 0.0;

    private Long productionNumber;

    @Embedded
    private Engine engine;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    public Car() {}

    public Car(String name, Integer numberOfSeats, Long productionNumber, Engine engine) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.productionNumber = productionNumber;
        this.engine = engine;
    }

    public void accelerate(double input) {
        if (input < -1.0) input = -1.0;
        if (input > 1.0) input = 1.0;
        
        // simple acceleration logic taking horsepower into account
        this.currentSpeed += input * (engine.getHorsepower() / 10.0);
        if (this.currentSpeed < 0) this.currentSpeed = 0.0;
    }

    public String formatCharacteristics() {
        return String.format("Name: %s, Type: %s, Production Number: %d, Horsepower: %.1f",
                name, this.getClass().getSimpleName(), productionNumber, engine.getHorsepower());
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getNumberOfSeats() { return numberOfSeats; }
    public void setNumberOfSeats(Integer numberOfSeats) { this.numberOfSeats = numberOfSeats; }
    public Double getCurrentSpeed() { return currentSpeed; }
    public void setCurrentSpeed(Double currentSpeed) { this.currentSpeed = currentSpeed; }
    public Long getProductionNumber() { return productionNumber; }
    public void setProductionNumber(Long productionNumber) { this.productionNumber = productionNumber; }
    public Engine getEngine() { return engine; }
    public void setEngine(Engine engine) { this.engine = engine; }
    public ParkingLot getParkingLot() { return parkingLot; }
    public void setParkingLot(ParkingLot parkingLot) { this.parkingLot = parkingLot; }
}

