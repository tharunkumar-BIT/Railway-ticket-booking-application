import java.util.*;

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

        if (confirmedList.size() < MAX_SEATS) {
            Ticket t = new Ticket(ticketCounter++, name, coachType, false);
            confirmedList.add(t);
            System.out.println("Booking confirmed...");
        } else if (waitingList.size() < MAX_WAITING) {
            Ticket t = new Ticket(ticketCounter++, name, coachType, true);
            waitingList.add(t);
            System.out.println("Ticket added to waiting list...");
        } else {
            System.out.println("Failed to book tickets");
        }
    }

    public void cancelTickets(int ticketId) {
        for (CoachType coach : CoachType.values()) {
            List<Ticket> confirmedList = confirmed.get(coach);
            Iterator<Ticket> it = confirmedList.iterator();
            while (it.hasNext()) {
                Ticket t = it.next();
                if (t.id == ticketId) {
                    it.remove();
                    System.out.println("Cancelled Ticket " + t);

                    List<Ticket> waitingList = waiting.get(coach);
                    if (!waitingList.isEmpty()) {
                        Ticket firstWaitingTicket = waitingList.remove(0);
                        firstWaitingTicket.isWaiting = false;
                        confirmedList.add(firstWaitingTicket);
                        System.out.println("Promoted to confirmed" + firstWaitingTicket);
                    }
                    return;
                }
            }

            List<Ticket> waitingList = waiting.get(coach);
            it = waitingList.iterator();
            while (it.hasNext()) {
                Ticket t = it.next();
                if (t.id == ticketId) {
                    it.remove();
                    System.out.println("Tickter removed from waiting list " + t);
                    return;
                }
            }
        }
        System.out.println("Ticket not found");
    }

    public void checkStatus(){
        for(CoachType coach : CoachType.values()){
            System.out.println("\n Coach: " + coach);
            System.out.println("Confirmed Tickets: ");
            confirmed.get(coach).forEach(System.out::println);
            System.out.println("Waiting List(s): ");
            waiting.get(coach).forEach(System.out::println);
        }
    }
}
