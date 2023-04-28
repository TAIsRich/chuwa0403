package com.chuwa.redbook.payload.responseDto;

import com.chuwa.redbook.payload.requestDto.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {
    String deviceType;
    List<Item> items;
}
