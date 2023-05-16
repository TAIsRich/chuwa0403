package com.richard.cookielearndarkui.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author zhuhaotian
 * @Date 2023/5/11
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {

    private List<PostDto> content;

    private int pageNo;

    private int pageSize;

    private long totalElements;

    private int totalPages;

    private boolean last;
}
