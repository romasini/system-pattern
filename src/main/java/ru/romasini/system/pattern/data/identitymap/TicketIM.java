package ru.romasini.system.pattern.data.identitymap;

import ru.romasini.system.pattern.entities.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketIM {
    private Map<Long, Ticket> ticketMap = new HashMap<>();
    private static TicketIM instance;

    private TicketIM() {
    }

    public static TicketIM getInstance() {
        if(instance == null){
            instance = new TicketIM();
        }
        return instance;
    }

    public static Ticket getTicket(Long id){
        return getInstance().ticketMap.get(id);
    }

    public static void addTicket(Ticket ticket){
        getInstance().ticketMap.put(ticket.getId(), ticket);
    }
}
