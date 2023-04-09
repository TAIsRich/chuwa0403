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
        Map<String, Integer> map = new LinkedHashMap<>();

        // Adding elements to the map
        map.put("John", 25);
        map.put("Mary", 30);
        map.put("Bob", 20);

        // Retrieving elements from the map
        int age1 = map.get("John");
        int age2 = map.get("Mary");
        int age3 = map.get("Bob");

        // Printing the retrieved values
        System.out.println("John's age is " + age1);
        System.out.println("Mary's age is " + age2);
        System.out.println("Bob's age is " + age3);
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
        Map<String, Integer> map = new LinkedHashMap<>();

        // Adding elements to the map
        map.put("John", 25);
        map.put("Mary", 30);
        map.put("Bob", 20);

        // Removing an element from the map
        map.remove("Mary");

        // Replacing an element in the map
        map.replace("Bob", 22);

        // Updating an element in the map
        map.put("Jane", 27);

        // Printing the updated map
        System.out.println(map);
    }
}
