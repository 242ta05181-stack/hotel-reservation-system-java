import java.util.*;

public class Hotel {

    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {

        rooms = FileManager.loadRooms();
        reservations = FileManager.loadReservations();

        updateRoomAvailability();
    }

    private void updateRoomAvailability() {

        for (Room room : rooms) {

            room.setAvailable(true);

            for (Reservation reservation : reservations) {

                if (reservation.getRoomNumber()
                        == room.getRoomNumber()
                        && reservation.getReservationStatus()
                        .equalsIgnoreCase("CONFIRMED")) {

                    room.setAvailable(false);
                }
            }
        }

        FileManager.saveRooms(rooms);
    }

    public void displayAllRooms() {

        System.out.println(
                "\n========== ALL ROOMS =========="
        );

        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void searchRooms(String category) {

        System.out.println(
                "\n====== AVAILABLE " +
                category.toUpperCase() +
                " ROOMS ======"
        );

        boolean found = false;

        for (Room room : rooms) {

            if (room.isAvailable()
                    && room.getCategory()
                    .equalsIgnoreCase(category)) {

                System.out.println(room);
                found = true;
            }
        }

        if (!found) {
            System.out.println(
                    "No available rooms found."
            );
        }
    }

    public Room findAvailableRoom(
            int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber
                    && room.isAvailable()) {

                return room;
            }
        }

        return null;
    }

    public void makeReservation(
            Scanner scanner) {

        displayAllRooms();

        System.out.print(
                "\nEnter room number: "
        );

        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room room =
                findAvailableRoom(roomNumber);

        if (room == null) {

            System.out.println(
                    "Room is not available."
            );

            return;
        }

        System.out.print(
                "Enter customer name: "
        );

        String name = scanner.nextLine();

        System.out.print(
                "Enter phone number: "
        );

        String phone = scanner.nextLine();

        System.out.print(
                "Enter number of nights: "
        );

        int nights = scanner.nextInt();
        scanner.nextLine();

        if (nights <= 0) {

            System.out.println(
                    "Number of nights must be greater than zero."
            );

            return;
        }

        double total =
                room.getPrice() * nights;

        System.out.println(
                "\nTotal Amount: ₹" + total
        );

        System.out.print(
                "Proceed with payment? (yes/no): "
        );

        String paymentChoice =
                scanner.nextLine();

        if (!paymentChoice.equalsIgnoreCase("yes")) {

            System.out.println(
                    "Booking cancelled."
            );

            return;
        }

        System.out.println(
                "\nProcessing payment..."
        );

        System.out.println(
                "Payment successful!"
        );

        String reservationId =
                generateReservationId();

        Reservation reservation =
                new Reservation(
                        reservationId,
                        name,
                        phone,
                        room.getRoomNumber(),
                        room.getCategory(),
                        nights,
                        total,
                        "PAID",
                        "CONFIRMED"
                );

        reservations.add(reservation);

        room.setAvailable(false);

        FileManager.saveRooms(rooms);
        FileManager.saveReservations(
                reservations
        );

        System.out.println(
                "\nBooking successful!"
        );

        System.out.println(reservation);
    }

    private String generateReservationId() {

        return "RES" +
                (1000 + reservations.size() + 1);
    }

    public void cancelReservation(
            Scanner scanner) {

        System.out.print(
                "\nEnter reservation ID: "
        );

        String id = scanner.nextLine();

        Reservation found = null;

        for (Reservation reservation
                : reservations) {

            if (reservation.getReservationId()
                    .equalsIgnoreCase(id)) {

                found = reservation;
                break;
            }
        }

        if (found == null) {

            System.out.println(
                    "Reservation not found."
            );

            return;
        }

        if (found.getReservationStatus()
                .equalsIgnoreCase("CANCELLED")) {

            System.out.println(
                    "Reservation is already cancelled."
            );

            return;
        }

        found.setReservationStatus(
                "CANCELLED"
        );

        for (Room room : rooms) {

            if (room.getRoomNumber()
                    == found.getRoomNumber()) {

                room.setAvailable(true);
                break;
            }
        }

        FileManager.saveRooms(rooms);
        FileManager.saveReservations(
                reservations
        );

        System.out.println(
                "Reservation cancelled successfully."
        );

        System.out.println(
                "Room " + found.getRoomNumber() +
                " is now available."
        );
    }

    public void viewReservation(
            Scanner scanner) {

        System.out.print(
                "\nEnter reservation ID: "
        );

        String id = scanner.nextLine();

        for (Reservation reservation
                : reservations) {

            if (reservation.getReservationId()
                    .equalsIgnoreCase(id)) {

                System.out.println(reservation);
                return;
            }
        }

        System.out.println(
                "Reservation not found."
        );
    }

    public void displayReservations() {

        System.out.println(
                "\n====== RESERVATIONS ======"
        );

        if (reservations.isEmpty()) {

            System.out.println(
                    "No reservations found."
            );

            return;
        }

        for (Reservation reservation
                : reservations) {

            System.out.println(reservation);
        }
    }
}
