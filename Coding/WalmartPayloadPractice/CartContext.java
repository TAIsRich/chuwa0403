package Coding.WalmartPayloadPractice;

import Coding.WalmartPayloadPractice.enums.CartIntent;
import Coding.WalmartPayloadPractice.enums.SlotType;

import java.util.Date;

public class CartContext {
    private CartIntent cartIntent;
    private SlotType slotType;
    private ThresholdInfo thresholdInfo;
    private Date slotExpirationTime;
    private Date slotExpirationTime_SC;
    private boolean isUnScheduledPickUp;
}
