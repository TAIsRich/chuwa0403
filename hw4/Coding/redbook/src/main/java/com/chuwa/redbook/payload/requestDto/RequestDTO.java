package com.chuwa.redbook.payload.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDTO {
    private P13n p13n;
    private boolean enableWplusCashbackValue;
    private boolean enableWplusBannersPostCartLoadPageValue;
    private boolean enableWplusRetentionNudge;
    private boolean enableGenericWalmartCash;
    private boolean enableGenericPageContext;
    private String tenant;
}

