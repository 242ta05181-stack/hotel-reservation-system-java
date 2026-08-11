public class Reservation {

    private String reservationId;
    private String customerName;
    private String phoneNumber;
    private int roomNumber;
    private String roomCategory;
    private int nights;
    private double totalAmount;
    private String paymentStatus;
    private String reservationStatus;

    public Reservation(
            String reservationId,
            String customerName,
            String phoneNumber,
            int roomNumber,
            String roomCategory,
            int nights,
            double totalAmount,
            String paymentStatus,
            String reservationStatus) {

        this.reservationId = reservationId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.roomCategory = roomCategory;
        this.nights = nights;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.reservationStatus = reservationStatus;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getNights() {
        return nights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public String toFileString() {

        return reservationId + "|" +
                customerName + "|" +
                phoneNumber + "|" +
                roomNumber + "|" +
                roomCategory + "|" +
                nights + "|" +
                totalAmount + "|" +
                paymentStatus + "|" +
                reservationStatus;
    }

    @Override
    public String toString() {

        return "\n------------------------------" +
                "\nReservation ID : " + reservationId +
                "\nCustomer Name   : " + customerName +
                "\nPhone Number    : " + phoneNumber +
                "\nRoom Number     : " + roomNumber +
                "\nRoom Category   : " + roomCategory +
                "\nNumber of Nights: " + nights +
                "\nTotal Amount    : ₹" + totalAmount +
                "\nPayment Status  : " + paymentStatus +
                "\nBooking Status  : " + reservationStatus +
                "\n------------------------------";
    }
}
