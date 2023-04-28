package com.example.cassandrablog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    @PrimaryKey
    private UUID id;

    private String title;
    private String author;
    private LocalDateTime start;
    private LocalDateTime end;
}
