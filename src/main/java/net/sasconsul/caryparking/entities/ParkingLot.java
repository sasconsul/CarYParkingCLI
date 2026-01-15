package net.sasconsul.caryparking.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;
@Entity
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private int capacity;

    @OneToMany(mappedBy = "parkingLot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Space> spaces = new ArrayList<>();

    public ParkingLot() {}

    public ParkingLot(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        for (int i = 1; i <= capacity; i++) {
            Space space = new Space();
            space.setNumber(i);
            space.setAvailable(true);
            space.setParkingLot(this);
            spaces.add(space);
        }
    }

    public void parkCar(Car car) {
        Space availableSpace = spaces.stream()
                .filter(Space::isAvailable)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: Parking lot is full capacity!"));

        availableSpace.setAvailable(false);
        availableSpace.setCar(car);
        car.setParkingLot(this);
    }

    public void removeCar(Car car) {
        Space spaceWithCar = spaces.stream()
                .filter(s -> car.equals(s.getCar()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Error: Car not found in this parking lot!"));

        spaceWithCar.setAvailable(true);
        spaceWithCar.setCar(null);
        car.setParkingLot(null);
    }

    public void printDirectory() {
        System.out.println("Parking Lot Directory for " + name + ":");
        for (Space space : spaces) {
            String carInfo = space.isAvailable() ? "Empty" : "Car: " + space.getCar().getName();
            System.out.println("Spot " + space.getNumber() + ": " + carInfo);
        }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public List<Space> getSpaces() { return spaces; }
    public void setSpaces(List<Space> spaces) { this.spaces = spaces; }
}
