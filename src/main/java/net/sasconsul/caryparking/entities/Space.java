package net.sasconsul.caryparking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int number;


    private String name;

    private String location;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id")
    private ParkingLot parkingLot;

    @OneToOne(mappedBy = "space")
    private Car car;


    public boolean isAvailable() {
        return this.available;
    }

    // Getters and setters
    // ...
}
