package com.chuwa.mongoblog.repository;

public interface CustomItemRepository {

    void updateItemQuantity(String itemName, float newQuantity);

}
