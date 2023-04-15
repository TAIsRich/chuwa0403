package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
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
        // Creating a new TreeMap
        TreeMap<String, Integer> myMap = new TreeMap<>();

        // Inserting values into the TreeMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Retrieving a value from the TreeMap
        int age = myMap.get("Mary");
        System.out.println("Mary's age is: " + age);

        // Printing out the TreeMap
        System.out.println("TreeMap: " + myMap);
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Creating a new TreeMap
        TreeMap<String, Integer> myMap = new TreeMap<>();

        // Inserting values into the TreeMap
        myMap.put("John", 25);
        myMap.put("Mary", 30);
        myMap.put("Bob", 27);

        // Removing a value from the TreeMap
        myMap.remove("Mary");

        // Replacing a value in the TreeMap
        myMap.replace("Bob", 28);

        // Updating a value in the TreeMap
        myMap.put("David", 35);

        // Printing out the updated TreeMap
        System.out.println("Updated TreeMap: " + myMap);
    }
}
