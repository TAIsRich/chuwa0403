package com.richard.cookielearndarkui.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private long id;

    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, message = "Comment body must be minimum 5 characters")
    private String body;

}
