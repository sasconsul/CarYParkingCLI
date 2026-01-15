package net.sasconsul.caryparking.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "car_parking")
public class CarParking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "space_id", referencedColumnName = "id")
    private Space space;

    // Constructors, getters, and setters
}
