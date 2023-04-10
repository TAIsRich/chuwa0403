package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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

        Map<String, Integer> h = new LinkedHashMap<>();
        h.put("apple", 1);
        h.put("banana", 2);
        h.put("cherry", 3);
        assertEquals(1, h.get("apple").intValue());
        assertEquals(2, h.getOrDefault("banana", 0).intValue());
        assertNull(h.get("durian"));
        assertTrue(h.containsKey("cherry"));
        assertFalse(h.containsValue(4));
        h.put("banana", 4);
        assertEquals(4, h.get("banana").intValue());
        h.putIfAbsent("apple", 5);
        assertEquals(1, h.get("apple").intValue());
        Set<String> keys = h.keySet();
        assertEquals(3, keys.size());
        assertTrue(keys.contains("banana"));
        Collection<Integer> values = h.values();
        assertEquals(3, values.size());
        assertTrue(values.contains(3));
        h.clear();
        assertTrue(h.isEmpty());
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
        Map<String, Integer> h = new HashMap<>();
        h.put("apple", 5);
        h.put("orange", 10);
        h.put("banana", 20);
        h.replace("orange", 10, 15);
        h.replace("banana", 25);
        h.replaceAll((key, value) -> value * 2);
        h.remove("apple");
        boolean removed = h.remove("banana", 30);
        h.compute("orange", (k, v) -> v + 5);
        h.computeIfAbsent("pear", k -> 8);
        h.computeIfPresent("banana", (k, v) -> v + 10);
    }
}
