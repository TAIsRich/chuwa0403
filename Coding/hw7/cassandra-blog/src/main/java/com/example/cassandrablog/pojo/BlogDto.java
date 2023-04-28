package com.example.cassandrablog.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {
    private UUID id;
    private String title;
    private String author;
}
