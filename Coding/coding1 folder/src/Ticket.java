import java.util.Date;

public class Ticket {
    private String id;
    private float amount;
    private Vehicle vehicle;
    private Date enterTime;
    private Date exitTime;

    private int status;//paid and unpaid
    private int paymentMethod;//Credit, Debit, Cash

    public Date getEnterTime() {
        return enterTime;
    }

    public Date getExitTime() {
        return exitTime;
    }
}
