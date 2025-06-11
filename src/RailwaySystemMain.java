import java.util.Scanner;

public class RailwaySystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RailwayReservation sys = new RailwayReservation();

        while (true) {
            System.out.println("\n -----Railway Reservation System-----");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Status");
            System.out.println("4. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter Coach (AC/NON_AC/SEATER): ");
                    CoachType coach = CoachType.valueOf(sc.next().toUpperCase());
                    sys.bookTicket(name, coach);
                    break;
                case 2:
                    System.out.println("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sys.cancelTickets(id);
                    break;
                case 3:
                    sys.checkStatus();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
