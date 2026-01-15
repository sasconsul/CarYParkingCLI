package net.sasconsul.caryparking.services;

import net.sasconsul.caryparking.entities.Space;
import net.sasconsul.caryparking.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingLotService {

    private final SpaceRepository spaceRepository;

    public ParkingLotService(@Autowired SpaceRepository spaceRepository) {
        this.spaceRepository = spaceRepository;
    }

    public List<Space> getAvailableSpaces(Long parkingLotId) {
        return spaceRepository.findByParkingLotId(parkingLotId)
                .stream()
                .filter(Space::isAvailable)
                .collect(Collectors.toList());
    }
}
