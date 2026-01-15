package net.sasconsul.caryparking.repository;

import net.sasconsul.caryparking.entities.CarParking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarParkingRepository extends CrudRepository<CarParking, Long> {
}
