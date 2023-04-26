package payload.requestbody;

import java.util.Date;
import java.util.List;

public class CartContext {
    private String cartIntent;
    private String slotType;
    private ThreadsholdInfo threadsholdInfo;
    private Date slotExpirationTime;
    private String slotExpirationTime_SC;
    private boolean isUnScheduledPickUp;

    private List<Item> items;

    public class ThreadsholdInfo {
        private int balanceToMinimumThreshold;
        private boolean belowMinFee;
        private boolean deliveryMinFee;
    }


}
