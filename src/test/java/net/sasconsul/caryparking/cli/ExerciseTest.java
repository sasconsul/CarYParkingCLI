package net.sasconsul.caryparking.cli;

import net.sasconsul.caryparking.entities.Car;
import net.sasconsul.caryparking.entities.ConvertibleCar;
import net.sasconsul.caryparking.entities.Engine;
import net.sasconsul.caryparking.entities.ParkingLot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ExerciseTest {

    @Test
    void runExercises() {
        System.out.println("########## Running Exercises ##########");

        // # 1 & 3: Prius and Boxster
        Engine priusEngine = new Engine(121.0, 53.0);
        Car prius = new Car("Prius", 5, 1001L, priusEngine);

        Engine boxsterEngine = new Engine(265.0, 32.0);
        ConvertibleCar boxster = new ConvertibleCar("Porsche Boxster", 2, 1002L, boxsterEngine);

        System.out.println("Exercise 1 & 3 Initial State:");
        System.out.println(prius.formatCharacteristics());
        System.out.println(boxster.formatCharacteristics());

        // # 2 & 3: Lower roof and race
        System.out.println("\nExercise 2 & 3: Racing!");
        boxster.moveRoofDown();

        double accelerationRate = 0.2;
        int steps = 0;
        while (prius.getCurrentSpeed() < 200 && boxster.getCurrentSpeed() < 200) {
            steps++;
            prius.accelerate(accelerationRate);
            boxster.accelerate(accelerationRate);
            System.out.printf("Step %d: Prius Speed = %.2f, Boxster Speed = %.2f%n",
                    steps, prius.getCurrentSpeed(), boxster.getCurrentSpeed());
            
            if (steps > 1000) break; // safety break
        }

        String winner = prius.getCurrentSpeed() >= 200 ? "Prius" : "Boxster";
        System.out.println("Winner is: " + winner);

        // # 4 & 5: Parking Lot
        System.out.println("\nExercise 4 & 5: Parking Lot");
        ParkingLot lot = new ParkingLot("Main Lot", 3);

        Car car3 = new Car("Tesla Model 3", 5, 1003L, new Engine(450.0, 130.0));
        Car car4 = new Car("BMW M3", 4, 1004L, new Engine(473.0, 20.0));
        
        // Try to park all 4 cars in lot of size 3
        List<Car> carsToPark = new ArrayList<>(List.of(prius, boxster, car3, car4));

        for (Car car : carsToPark) {
            try {
                System.out.println("Attempting to park " + car.getName());
                lot.parkCar(car);
                System.out.println("Parked " + car.getName());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                if (e.getMessage().contains("full capacity")) {
                    System.out.println("Lot full. Removing a car to make space...");
                    lot.removeCar(carsToPark.get(0)); // Remove Prius
                    System.out.println("Removed " + carsToPark.get(0).getName());

                    // Try parking again
                    System.out.println("Attempting to park " + car.getName() + " again");
                    lot.parkCar(car);
                    System.out.println("Parked " + car.getName());
                }
            }
        }

        System.out.println("\nFinal Lot Directory:");
        lot.printDirectory();
        
        // Assertions
        assertTrue(prius.getCurrentSpeed() >= 200 || boxster.getCurrentSpeed() >= 200);
        assertEquals(3, lot.getSpaces().stream().filter(s -> !s.isAvailable()).count());
    }
}
