package Receipt;

import java.time.LocalDate;

public class TicketNo {
    public static String generateTicketNo(String name) {
        LocalDate date = LocalDate.now();
        String PLANEID = "ERM101";
        String ticketNo = date + PLANEID + name.hashCode();
        return ticketNo;
    }
}
