package com.chuwa.cassandrablog.controller;

import com.chuwa.cassandrablog.entity.Blog;
import com.chuwa.cassandrablog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;

    @GetMapping(value = "blog/{name}")
    public List<Blog> getUser(@PathVariable String name){
        return blogService.getUserByName(name);
    }
}