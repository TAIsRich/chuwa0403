package request;

import java.util.ArrayList;
import java.util.List;

enum FulfillmentType{
    SHIPPING,PICKUP
}
enum FulfillmentGroup{
    SCGroup,FCGroup
}
public class Item {
    public long id;
    public String availableQty;
    public FulfillmentType fulfillmentType;
    public double price;
    public Double wasPrice;
    public FulfillmentGroup fulfillmentGroup;
    public ArrayList<String> badges;
}
