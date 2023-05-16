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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    private String name;

    @JsonProperty(value = "account")
    private String account;

    private String email;

    private String password;
}
