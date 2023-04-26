package payload.requestbody;

import java.util.List;

public class UserReqInfo {
    private String preferredStoreId;
    private List<String> storeIds;
    private CartContext cartContext;
    private List<String> requestType; //enum

}
