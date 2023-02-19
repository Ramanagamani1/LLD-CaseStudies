package services;

import models.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {

    private TicketRepository ticketRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(TicketRepository ticketRepository,
                         SpotAssignmentStrategy spotAssignmentStrategy,
                         ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket generateTicket(Long parkingLotId,Vehicle vehicle,SpotType spotType,EntryGate entryGate) {
        ParkingLot parkingLot = parkingLotRepository.getById(parkingLotId);
        ParkingSpot spot = spotAssignmentStrategy.assignSpot(parkingLot,spotType ,entryGate);
        if (spot == null) {
            return null;
        } else {
            Ticket ticket = new Ticket();
            ticket.setEntryGate(entryGate);
            ticket.setGeneratedBy(entryGate.getOperator());
            ticket.setParkingSpot(spot);
            ticket.setVehicle(vehicle);
            ticket.setEntryTime(new Date());
            Ticket savedTicket = ticketRepository.save(ticket);
            return savedTicket;
        }
    }
}
