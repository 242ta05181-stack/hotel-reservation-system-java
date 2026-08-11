import java.io.*;
import java.util.*;

public class FileManager {

    private static final String ROOM_FILE =
            "data/rooms.txt";

    private static final String RESERVATION_FILE =
            "data/reservations.txt";

    public static void createDataDirectory() {

        File directory = new File("data");

        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public static void saveRooms(List<Room> rooms) {

        createDataDirectory();

        try (PrintWriter writer =
                     new PrintWriter(new FileWriter(ROOM_FILE))) {

            for (Room room : rooms) {

                writer.println(
                        room.getRoomNumber() + "|" +
                        room.getCategory() + "|" +
                        room.getPrice() + "|" +
                        room.isAvailable()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving rooms: " + e.getMessage()
            );
        }
    }

    public static List<Room> loadRooms() {

        createDataDirectory();

        List<Room> rooms = new ArrayList<>();

        File file = new File(ROOM_FILE);

        if (!file.exists()) {

            rooms.add(new Room(101, "Standard", 1500));
            rooms.add(new Room(102, "Standard", 1500));
            rooms.add(new Room(201, "Deluxe", 2500));
            rooms.add(new Room(202, "Deluxe", 2500));
            rooms.add(new Room(301, "Suite", 4000));
            rooms.add(new Room(302, "Suite", 4000));

            saveRooms(rooms);

            return rooms;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                if (parts.length == 4) {

                    int roomNumber =
                            Integer.parseInt(parts[0]);

                    String category = parts[1];

                    double price =
                            Double.parseDouble(parts[2]);

                    boolean available =
                            Boolean.parseBoolean(parts[3]);

                    rooms.add(
                            new Room(
                                    roomNumber,
                                    category,
                                    price,
                                    available
                            )
                    );
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading rooms: " +
                    e.getMessage()
            );
        }

        return rooms;
    }

    public static void saveReservations(
            List<Reservation> reservations) {

        createDataDirectory();

        try (PrintWriter writer =
                     new PrintWriter(
                             new FileWriter(RESERVATION_FILE))) {

            for (Reservation reservation : reservations) {

                writer.println(
                        reservation.toFileString()
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "Error saving reservations: " +
                    e.getMessage()
            );
        }
    }

    public static List<Reservation> loadReservations() {

        createDataDirectory();

        List<Reservation> reservations =
                new ArrayList<>();

        File file =
                new File(RESERVATION_FILE);

        if (!file.exists()) {
            return reservations;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts =
                        line.split("\\|");

                if (parts.length == 9) {

                    Reservation reservation =
                            new Reservation(
                                    parts[0],
                                    parts[1],
                                    parts[2],
                                    Integer.parseInt(parts[3]),
                                    parts[4],
                                    Integer.parseInt(parts[5]),
                                    Double.parseDouble(parts[6]),
                                    parts[7],
                                    parts[8]
                            );

                    reservations.add(reservation);
                }
            }

        } catch (IOException | NumberFormatException e) {

            System.out.println(
                    "Error loading reservations: " +
                    e.getMessage()
            );
        }

        return reservations;
    }
}
