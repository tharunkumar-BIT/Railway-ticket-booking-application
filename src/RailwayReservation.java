import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RailwayReservation {
    private static final int MAX_SEATS = 50;
    private static final int MAX_WAITING = 10;

    private int ticketCounter = 1;

    private Map<CoachType, List<Ticket>> confirmed = new HashMap<>();
    private Map<CoachType, List<Ticket>> waiting = new HashMap<>();

    public RailwayReservation() {
        for (CoachType coach : CoachType.values()) {
            confirmed.put(coach, new ArrayList<>());
            waiting.put(coach, new ArrayList<>());
        }
    }

    public void bookTicket(String name, CoachType coachType) {
        List<Ticket> confirmedList = confirmed.get(coachType);
        List<Ticket> waitingList = waiting.get(coachType);

        if(confirmedList.size() < MAX_SEATS){
            Ticket t = new Ticket(ticketCounter++, name, coachType, false);
            confirmedList.add(t);
            System.out.println("Booking confirmed...");
        }
        else if(waitingList.size() < MAX_WAITING){
            Ticket t = new Ticket(ticketCounter++, name, coachType, true);
            waitingList.add(t);
            System.out.println("Ticket added to waiting list...");
        }
        else{
            System.out.println("Failed to book tickets");
        }
    }
}
