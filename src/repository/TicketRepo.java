package repository;

import model.Ticket;

import java.util.Map;
import java.util.Optional;

public class TicketRepo {
    private long lastSavedId;
    private Map<Long, Ticket> ticketMap;


    public TicketRepo(Map<Long , Ticket> ticketMap) {
        this.ticketMap = ticketMap;
        lastSavedId = 0L;
    }

    public Ticket save(Ticket ticket) {
        lastSavedId++;
        ticket.setId(lastSavedId);
        ticketMap.put(lastSavedId, ticket);
        return ticket;
    }

    public Optional<Ticket> getTicketByNumber(String  ticketNo){
        if (!ticketMap.isEmpty()) {
            for (Ticket ticket : ticketMap.values()){
                if (ticket.getTicketNumber().equals(ticketNo)){
                    return Optional.of(ticket);
                }
            }
        }
        return Optional.empty();
    }


    public long getLastSavedId() {
        return lastSavedId;
    }

    public void setLastSavedId(long lastSavedId) {
        this.lastSavedId = lastSavedId;
    }

    public Map<Long, Ticket> getTicketMap() {
        return ticketMap;
    }

    public void setTicketMap(Map<Long, Ticket> ticketMap) {
        this.ticketMap = ticketMap;
    }
}
