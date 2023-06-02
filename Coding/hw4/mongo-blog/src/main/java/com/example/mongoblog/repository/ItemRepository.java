package com.example.mongoblog.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mongoblog.model.BlogItem;

public interface ItemRepository extends MongoRepository<BlogItem, String> {

    @Query("{title:'?0'}")
    BlogItem findItemByName(String title);

    @Query(value="{content:'?0'}", fields="{'title' : 1}")
    List<BlogItem> findAll(String category);

    public long count();

}