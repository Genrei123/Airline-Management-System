package Receipt;

public class TicketNo {
    public static String getTicketNo(String name) {
        return "T" + String.format("%06d", (int) (Math.random() * 1000000));
    }
}
