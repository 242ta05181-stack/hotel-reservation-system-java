import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner =
                new Scanner(System.in);

        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println(
                    "\n================================"
            );

            System.out.println(
                    "     HOTEL RESERVATION SYSTEM"
            );

            System.out.println(
                    "================================"
            );

            System.out.println(
                    "1. Display All Rooms"
            );

            System.out.println(
                    "2. Search Standard Rooms"
            );

            System.out.println(
                    "3. Search Deluxe Rooms"
            );

            System.out.println(
                    "4. Search Suite Rooms"
            );

            System.out.println(
                    "5. Make Reservation"
            );

            System.out.println(
                    "6. Cancel Reservation"
            );

            System.out.println(
                    "7. View Booking Details"
            );

            System.out.println(
                    "8. Display All Reservations"
            );

            System.out.println(
                    "9. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            while (!scanner.hasNextInt()) {

                System.out.println(
                        "Please enter a valid number."
                );

                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    hotel.displayAllRooms();
                    break;

                case 2:
                    hotel.searchRooms("Standard");
                    break;

                case 3:
                    hotel.searchRooms("Deluxe");
                    break;

                case 4:
                    hotel.searchRooms("Suite");
                    break;

                case 5:
                    hotel.makeReservation(scanner);
                    break;

                case 6:
                    hotel.cancelReservation(scanner);
                    break;

                case 7:
                    hotel.viewReservation(scanner);
                    break;

                case 8:
                    hotel.displayReservations();
                    break;

                case 9:
                    System.out.println(
                            "Thank you for using the Hotel Reservation System!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 9);

        scanner.close();
    }
}
