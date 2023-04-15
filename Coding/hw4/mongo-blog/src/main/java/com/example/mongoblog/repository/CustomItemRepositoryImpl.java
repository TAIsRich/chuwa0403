package com.example.mongoblog.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.example.mongoblog.model.BlogItem;
import com.mongodb.client.result.UpdateResult;
@Component
public class CustomItemRepositoryImpl implements CustomItemRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    public void updateItemContent(String itemTitle, String newContent) {
        Query query = new Query(Criteria.where("title").is(itemTitle));
        Update update = new Update();
        update.set("content", newContent);

        UpdateResult result = mongoTemplate.updateFirst(query, update, BlogItem.class);

        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");

    }
}
