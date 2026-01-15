package net.sasconsul.caryparking.repository;

import net.sasconsul.caryparking.entities.ParkingLot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingLotRepository extends CrudRepository<ParkingLot, Long> {

    List<ParkingLot> findByName(String name);
}
