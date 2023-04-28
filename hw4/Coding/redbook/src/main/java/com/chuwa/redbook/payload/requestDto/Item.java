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
public class Item {
    private String id;
    private String availableQty;
    private String fulfillmentType;
    private double price;
    private Double wasPrice;
    private String fulfillmentGroup;
    private List<String> badges;

}
