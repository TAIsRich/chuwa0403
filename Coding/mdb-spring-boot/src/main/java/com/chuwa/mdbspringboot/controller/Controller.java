package com.chuwa.mdbspringboot.controller;

import com.chuwa.mdbspringboot.model.GroceryItem;
import com.chuwa.mdbspringboot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping{"/items"}
public class Controller {
    @Autowired
    private ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity<String> createItemPost(){
        itemRepository.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        return  new ResponseEntity("Create successfully", HttpStatus.CREATED);
    }
}
