package net.sasconsul.caryparking.repository;

import net.sasconsul.caryparking.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    List<Car> findByMake(String make);

    List<Car> findByModel(String model);

    List<Car> findByYear(int year);
}
