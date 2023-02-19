import controllers.ParkingLotController;
import controllers.TicketController;
import dtos.*;
import models.*;
import repositories.ParkingLotRepository;
import repositories.TicketRepository;
import services.ParkingLotService;
import services.TicketService;
import strategies.ObjectRegistry;
import strategies.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import strategies.spotassignmentstrategy.SpotAssignmentStrategy;

import java.io.ObjectStreamException;

public class Main {

    public static void main(String[] args) {
        ObjectRegistry.put("parkingLotRepository",new ParkingLotRepository());
        ObjectRegistry.put("parkingLotService",new ParkingLotService(
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("parkingLotController",new ParkingLotController(
                (ParkingLotService) ObjectRegistry.get("parkingLotService")
        ));
        ObjectRegistry.put("ticketRepository",new TicketRepository());
        ObjectRegistry.put("spotAssignmentStrategy", new RandomSpotAssignmentStrategy());
        ObjectRegistry.put("ticketService",new TicketService(
                (TicketRepository) ObjectRegistry.get("ticketRepository"),
                (SpotAssignmentStrategy) ObjectRegistry.get("spotAssignmentStrategy"),
                (ParkingLotRepository) ObjectRegistry.get("parkingLotRepository")
        ));
        ObjectRegistry.put("ticketController",new TicketController(
                (TicketService) ObjectRegistry.get("ticketService")
        ));


        ParkingLotController controller = (ParkingLotController) ObjectRegistry.get("parkingLotController");

        CreateParkingLotRequestDto requestDto = new CreateParkingLotRequestDto();
        requestDto.setAddress("Visakhapatnam Airport");
        requestDto.setNumberOfFloors(4);

        CreateParkingLotResponseDto responseDto = controller.createParkingLot(requestDto);

        System.out.println(responseDto.getParkingLot());

        UpdateParkingLotRequestDto updateRequest = new UpdateParkingLotRequestDto();
        updateRequest.setParkingLotId(1L);
        updateRequest.setAddress("Hyderabad");

        UpdateParkingLotResponseDto responseDto1 = controller.updateAddress(updateRequest);
        System.out.println(responseDto1);

        EntryGate entryGate = new EntryGate();
        entryGate.setGateStatus(GateStatus.OPEN);
        entryGate.setGateType(GateType.ENTRY);
        entryGate.setNumber(1);
        entryGate.setOperator(new Operator());


        GenerateTicketRequestDto ticketRequestDto = new GenerateTicketRequestDto();
        ticketRequestDto.setEntryGate(entryGate);
        ticketRequestDto.setVehicle(new Vehicle());
        ticketRequestDto.setParkingLotId(1L);
        ticketRequestDto.setSpotType(SpotType.MEDIUM);

        TicketController ticketController = (TicketController) ObjectRegistry.get("ticketController");

        GenerateTicketResponseDto ticketResponseDto = ticketController.generateTicket(ticketRequestDto);

        System.out.println(ticketResponseDto);
    }
}
