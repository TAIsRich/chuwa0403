package com.chuwa.learn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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
        Map<String, Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        System.out.println(map);
        map.putIfAbsent("three",3);
        System.out.println(map);
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("four",4);
        map1.put("five",5);
        map.putAll(map1);
        System.out.println(map);
        System.out.println(map.get("four"));
        System.out.println(map.getOrDefault("two",2));
        System.out.println(map.containsKey("two"));
        System.out.println(map.containsValue(2));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());

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
        Map<String, Integer> map = new HashMap<>();
        map.put("two", 2);
        map.put("four", 4);
        map.put("six", 6);
        System.out.println(map);

        map.replace("two",2,12);
        map.replace("four",14);
        System.out.println(map);

        map.replaceAll((key, value) -> value * 2);
        map.remove("four");
        System.out.println(map);
        map.compute("two", (key, value) -> value *2);
        System.out.println(map);
        map.computeIfAbsent("five", value -> 100 * 2);
        map.computeIfPresent("two", (key, value) -> value * 2);
        System.out.println(map);
    }
}
