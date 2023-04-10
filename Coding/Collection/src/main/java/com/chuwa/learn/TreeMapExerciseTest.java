package com.chuwa.learn;

import org.junit.Test;
import java.util.TreeMap;
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
        map.put("one",1);
        map.put("two",2);
        map.putIfAbsent("three",3);
        TreeMap<String, Integer> map1 = new TreeMap<>();
        map.put("four",4);
        map.put("five",5);
        map.putAll(map1);
        System.out.println(map);
        System.out.println(map.get("one"));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());
        System.out.println(map.containsKey("five"));
        System.out.println(map.containsValue(4));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.isEmpty());

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
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        System.out.println(map);
        map.replace("two", 2, 12);
        System.out.println(map);
        map.replace("three", 13);
        System.out.println(map);
        map.remove("one");
        System.out.println(map);

    }
}
