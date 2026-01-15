package net.sasconsul.caryparking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String make;

    private String model;

    private Long year;

    private String color;

    private Long numberOfSeats;

    private Long productionNumber;

    private Double horsepower;

    private Double mpg;

    private Boolean convertible;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    // getters and setters
}

