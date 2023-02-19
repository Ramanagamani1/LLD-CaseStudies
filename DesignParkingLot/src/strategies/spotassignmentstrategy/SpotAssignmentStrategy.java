package strategies.spotassignmentstrategy;

import models.EntryGate;
import models.ParkingLot;
import models.ParkingSpot;
import models.SpotType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot, SpotType spotType, EntryGate entryGate);
}
