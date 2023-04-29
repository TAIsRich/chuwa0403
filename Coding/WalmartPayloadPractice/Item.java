package Coding.WalmartPayloadPractice;

import Coding.WalmartPayloadPractice.enums.items.Badge;
import Coding.WalmartPayloadPractice.enums.items.FulfillmentGroup;
import Coding.WalmartPayloadPractice.enums.items.FulfillmentType;

public class Item {
    private String id;
    private String availableQty;
    private FulfillmentType fulfillmentType;
    private Double price;
    private Double wasPrice;
    private FulfillmentGroup fulfillmentGroup;
    private Badge[] badges;
}
