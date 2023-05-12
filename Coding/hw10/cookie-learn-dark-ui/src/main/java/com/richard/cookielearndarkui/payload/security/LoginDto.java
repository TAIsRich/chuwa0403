package com.richard.cookielearndarkui.payload.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @JsonProperty("accountOrEmail")
    private String accountOrEmail;

    private String password;
}
