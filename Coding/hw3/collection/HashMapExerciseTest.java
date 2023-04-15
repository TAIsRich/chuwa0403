package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Map<String, Integer> h = new HashMap<>();

        h.put("A", 1);
        h.put("B", 2);
        h.put("C", 3);

        int value1 = h.get("A");
        int value2 = h.get("B");
        int value3 = h.getOrDefault("C", 4);
        boolean keyExists = h.containsKey("A");
        boolean valueExists = h.containsValue(2);
        Set<String> keys = h.keySet();
        Collection<Integer> values = h.values();
        boolean isEmpty = h.isEmpty();

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
        h.put("A", 1);
        h.put("B", 2);
        h.put("C", 3);

        h.replace("B", 2, 5);
        h.replace("C", 5);
        h.replaceAll((key, value) -> value + 10);
        h.remove("B");
        h.remove("A", 1);
        h.compute("C", (key, value) -> value == null ? 0 : value + 6);
        h.compute("D", (key, value) -> value == null ? 5 : value + 7);
        h.computeIfAbsent("E", key -> 15);
        h.computeIfPresent("C", (key, value) -> value + 11);
    }
}
