package hw7.payload.request_body;

import java.util.List;
import java.util.Set;

public class UserReqInfo {
    private Long preferredStoreId;
    private List<Long> storeIds;
    private CartContext cartContext;
    private Set<String> requestType;
}
