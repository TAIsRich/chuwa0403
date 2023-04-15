package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Creating a new LinkedHashMap
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<>();

        // Inserting values into the LinkedHashMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Retrieving a value from the LinkedHashMap
        int johnAge = myMap.get("John");
        System.out.println("John's age: " + johnAge);

        // Printing out the LinkedHashMap
        System.out.println("LinkedHashMap: " + myMap);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Creating a new LinkedHashMap
        LinkedHashMap<String, Integer> myMap = new LinkedHashMap<>();

        // Inserting values into the LinkedHashMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Removing a value from the LinkedHashMap
        myMap.remove("Mary");

        // Replacing a value in the LinkedHashMap
        myMap.replace("Bob", 28);

        // Updating a value in the LinkedHashMap
        myMap.put("John", 26);

        // Printing out the updated LinkedHashMap
        System.out.println("Updated LinkedHashMap: " + myMap);
    }
}
