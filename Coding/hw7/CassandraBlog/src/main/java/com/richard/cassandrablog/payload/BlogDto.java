package com.richard.cassandrablog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private long id;
    private String title;
    private String author;
    private String content;
}
