import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reservation {
    private String name;
    private String date;
    private int numberOfGuests;

    public Reservation(String name, String date, int numberOfGuests) {
        this.name = name;
        this.date = date;
        this.numberOfGuests = numberOfGuests;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }
}

class ReservationSystem {
    private List<Reservation> reservations;

    public ReservationSystem() {
        reservations = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void displayReservations() {
        System.out.println("All Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println("Name: " + reservation.getName());
            System.out.println("Date: " + reservation.getDate());
            System.out.println("Number of Guests: " + reservation.getNumberOfGuests());
            System.out.println("---------------------------");
        }
    }
}

public class OnlineReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("1. Make a Reservation");
            System.out.println("2. View Reservations");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the reservation date: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter the number of guests: ");
                    int numberOfGuests = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Reservation reservation = new Reservation(name, date, numberOfGuests);
                    reservationSystem.addReservation(reservation);
                    System.out.println("Reservation added successfully!");
                    break;
                case 2:
                    reservationSystem.displayReservations();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }

        System.out.println("Thank you for using the Online Reservation System!");
        scanner.close();
    }
}