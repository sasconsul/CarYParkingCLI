package net.sasconsul.caryparking.repository;

import net.sasconsul.caryparking.entities.Space;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpaceRepository extends CrudRepository<Space, Long> {

    List<Space> findByParkingLotId(Long parkingLotId);

    List<Space> findByAvailable(boolean available);
}
