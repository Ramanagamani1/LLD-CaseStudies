package repositories;

import models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long, Ticket> tickets = new HashMap<>();

    private Long ticketCount = 0L;

    public Ticket save(Ticket ticket) {
        ticketCount+=1;
        ticket.setId(ticketCount);
        tickets.put(ticketCount,ticket);
        return ticket;
    }
}
