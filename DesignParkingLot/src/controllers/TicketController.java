package controllers;

import dtos.GenerateTicketRequestDto;
import dtos.GenerateTicketResponseDto;
import models.Ticket;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto request) {
          Ticket createdTicket = ticketService.generateTicket(request.getParkingLotId(),
                  request.getVehicle(),
                  request.getSpotType(),
                  request.getEntryGate());

          GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
          responseDto.setTicket(createdTicket);
          return responseDto;
    }
}
