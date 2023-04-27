package request;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

public class CartContext {
    public String cartIntent;
    public String slotType;
    public ThresholdInfo thresholdInfo;

    public Timestamp slotExpirationTime;
    public Timestamp slotExpirationTime_SC;
    public Boolean isUnScheduledPickUp;
    public ArrayList<Item> items;
}
