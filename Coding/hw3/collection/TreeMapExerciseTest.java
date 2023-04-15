package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.*;

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

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        assertEquals(Integer.valueOf(30), map.get("Bob"));
        assertEquals("Alice", map.firstKey());
        assertEquals("Charlie", map.lastKey());
        assertTrue(map.containsKey("Bob"));
        assertTrue(map.containsValue(35));
        Set<String> keySet = map.keySet();
        assertEquals(3, keySet.size());
        assertTrue(keySet.contains("Alice"));


        Collection<Integer> values = map.values();
        assertEquals(3, values.size());
        assertTrue(values.contains(25));
        assertFalse(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Alice", 23);
        map.put("Bob", 28);
        map.put("Charlie", 32);
        map.remove("Bob");
        map.replace("Alice", 25);
        map.replace("Charlie", 32, 35);
    }
}
