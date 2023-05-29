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
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Inserting elements into the TreeMap
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");

        // Retrieving elements from the TreeMap
        System.out.println("The value of key 1 is: " + treeMap.get(1)); // prints "The value of key 1 is: One"
        System.out.println("The value of key 2 is: " + treeMap.get(2)); // prints "The value of key 2 is: Two"
        System.out.println("The value of key 3 is: " + treeMap.get(3)); // prints "The value of key 3 is: Three"
        System.out.println("The value of key 4 is: " + treeMap.get(4)); // prints "The value of key 4 is: Four"

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Adding elements to the TreeMap
        treeMap.put("Alice", 25);
        treeMap.put("Bob", 30);
        treeMap.put("Charlie", 35);
        treeMap.put("David", 40);

        // Removing an entry from the TreeMap
        treeMap.remove("Charlie");
        System.out.println("After removing Charlie: " + treeMap);

        // Replacing an entry in the TreeMap
        treeMap.replace("Bob", 33);
        System.out.println("After replacing Bob: " + treeMap);

        // Updating an entry in the TreeMap
        Integer davidAge = treeMap.get("David");
        treeMap.put("David", davidAge + 1);
        System.out.println("After updating David: " + treeMap);
    }
}
