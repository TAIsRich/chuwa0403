package com.chuwa.learn.mongoblog.controller;

import com.chuwa.learn.mongoblog.model.GroceryItem;
import com.chuwa.learn.mongoblog.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items/update-category")
public class PostController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    ItemRepository groceryItemRepo;

    @PostMapping
    public ResponseEntity<String> updateCategory(@RequestParam String oldCategory, @RequestParam String newCategory){
        try{
            List<GroceryItem> list = groceryItemRepo.findAll(oldCategory);

            list.forEach(item -> {
                // Update the category in each document
                item.setCategory(newCategory);
            });

            // Save all the items in database
            List<GroceryItem> itemsUpdated = groceryItemRepo.saveAll(list);

            if(itemsUpdated != null) {
                System.out.println("Successfully updated " + itemsUpdated.size() + " items.");
            }
            return ResponseEntity.ok("Successfully updated " + itemsUpdated.size() + " items.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
