package request;

import java.util.ArrayList;

public class UserReqInfo {
    public long preferredStoreId;
    public ArrayList<Long> storedIds;
    public CartContext cartContext;
    public ArrayList<String> requestType;
}
