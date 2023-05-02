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
public class CartContext {
    private String cartIntent;
    private String slotType;
    private ThresholdInfo thresholdInfo;
    private String slotExpirationTime;
    private String slotExpirationTime_SC;
    private boolean isUnScheduledPickUp;
    private List<Item> items;

}
