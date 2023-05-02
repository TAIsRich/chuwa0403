package com.richard.cassandrablog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @Author zhuhaotian
 * @Date 2023/4/28
 */

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {

    @PrimaryKey
    private long id;

    private String title;
    private String author;
    private String content;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
}
