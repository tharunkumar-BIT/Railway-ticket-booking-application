public class Ticket {
    int id;
    String passengerName;
    CoachType coachType;
    boolean isWaiting;

    public Ticket(int id, String passengerName, CoachType coachType, boolean isWaiting) {
        this.id = id;
        this.passengerName = passengerName;
        this.coachType = coachType;
        this.isWaiting = isWaiting;
    }

    public String toString() {
        return "Ticket ID: " + id + ", Passenger Name: " + passengerName + ", Coach Type: " + coachType + (isWaiting ? " (Waiting) " : " (Confirmed) ");
    }
}
