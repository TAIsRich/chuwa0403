package com.chuwa.redbook.payload.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThresholdInfo {
    private double balanceToMinimumThreshold;
    private Double belowMinFee;
    private Double deliveryMinFee;

}
