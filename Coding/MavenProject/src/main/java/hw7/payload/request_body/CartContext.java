package hw7.payload.request_body;

import java.util.Date;
import java.util.List;

public class CartContext {
    private String cartIntent;
    private String slotType;
    private ThresholdInfo thresholdInfo;
    private Date slotExpirationTime;
    private Date slotExpirationTime_SC;
    private Boolean isUnScheduledPickUp;
    private List<ItemInfo> items;
}
