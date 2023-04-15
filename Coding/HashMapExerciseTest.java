package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
// Creating a new HashMap
        HashMap<String, Integer> myMap = new HashMap<>();

        // Inserting values into the HashMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Retrieving values from the HashMap
        int johnAge = myMap.get("John");
        int maryAge = myMap.get("Mary");
        int bobAge = myMap.get("Bob");

        // Printing out the retrieved values
        System.out.println("John's age is: " + johnAge);
        System.out.println("Mary's age is: " + maryAge);
        System.out.println("Bob's age is: " + bobAge);
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
        // Creating a new HashMap
        HashMap<String, Integer> myMap = new HashMap<>();

        // Inserting values into the HashMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Removing a value from the HashMap
        myMap.remove("Mary");

        // Replacing a value in the HashMap
        myMap.replace("Bob", 28);

        // Updating a value in the HashMap
        int johnAge = myMap.get("John");
        myMap.put("John", johnAge + 1);

        // Printing out the updated HashMap
        System.out.println("Updated HashMap: " + myMap);
    }
}
