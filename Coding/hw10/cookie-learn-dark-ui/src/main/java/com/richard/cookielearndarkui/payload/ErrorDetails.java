package com.richard.cookielearndarkui.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private Date timestamp;

    private String message;

    private String details;

}
