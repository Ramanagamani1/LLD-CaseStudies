package services;

import models.ParkingLot;
import repositories.ParkingLotRepository;

public class ParkingLotService {

    public ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(ParkingLot parkingLot) {
         ParkingLot createdLot = parkingLotRepository.save(parkingLot);
         return createdLot;
    }

    public ParkingLot updateAddress(Long parkingLotId,String address) {
        ParkingLot currentParkingLot = parkingLotRepository.getById(parkingLotId);
        currentParkingLot.setAddress(address);
        ParkingLot updatedParkingLot = parkingLotRepository.update(parkingLotId,currentParkingLot);
        return updatedParkingLot;
    }
}
