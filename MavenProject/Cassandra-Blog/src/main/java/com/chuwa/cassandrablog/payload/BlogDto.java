package com.chuwa.cassandrablog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    @PrimaryKey
    private Long id;

    private String title;
    private String user;
    private String content;
}
