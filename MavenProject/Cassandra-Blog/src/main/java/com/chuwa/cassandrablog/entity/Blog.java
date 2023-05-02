package com.chuwa.cassandrablog.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Indexed;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.Instant;
@Data
@Table(value = "blogs")
public class Blog  implements Serializable {
    @PrimaryKey
    private Integer id;
    private String name;
    @Indexed
    private Integer age;

}