package com.chuwa.redbook.payload.requestDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReqInfo {
    private int preferredStoreId;
    private List<Integer> storeIds;
    private CartContext cartContext;
    private List<String> requestType;

}
