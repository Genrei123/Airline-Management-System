package Homepage;

import java.time.LocalDate;
import java.util.Date;

public class Booking {
    private String seatNo;
    private String destination;
    private String Origin;
    private String Class;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String suffix;
    int age;
    Date birthdate;
    double amount;
    LocalDate booking_date;
    String departure;

    String TicketNo;

    String flight_no;

    // Singleton
    private static Booking instance = null;

    private Booking() {}

    public void setTicketNo(String TicketNo) {
        this.TicketNo = TicketNo;
    }

    public String getTicketNo() {
        return TicketNo;
    }

    public static Booking getInstance() {
        if (instance == null) {
            instance = new Booking();
        }
        return instance;
    }

    public void setBooking_date(LocalDate booking_date) {
        this.booking_date = booking_date;
    }

    public LocalDate getBooking_date() {
        return booking_date;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getClass1() {
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;

        if (Class.equals("Economy")) {
            this.amount = 1000;
        }
        else if (Class.equals("Premium Economy")) {
            this.amount = 1500;
        }
        else if (Class.equals("Business")) {
            this.amount = 2000;
        } else if (Class.equals("First Class")) {
            this.amount = 3000;
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setBirth_date(LocalDate date) {
        this.birthdate = java.sql.Date.valueOf(date);
    }


    public String getFlight_no() {
        return this.flight_no = flight_no;
    }

    public void setFlight_no(String flight_no) {
        this.flight_no = flight_no;
    }
}
