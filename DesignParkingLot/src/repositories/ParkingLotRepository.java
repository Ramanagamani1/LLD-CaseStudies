package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long,ParkingLot> repository = new HashMap<>();

    private Long lastCount = 0L;

    public ParkingLot save(ParkingLot parkingLot) {
        lastCount+=1;
        parkingLot.setId(lastCount);
        repository.put(lastCount,parkingLot);
        return parkingLot;
    }

    public ParkingLot getById(Long id) {
        return repository.get(id);
    }

    public ParkingLot update(Long id,ParkingLot parkingLot) {
        repository.put(id,parkingLot);
        return repository.get(id);
    }
}
