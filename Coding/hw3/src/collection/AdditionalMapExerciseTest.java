package com.chuwa.exercise.collection;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Min He
 * @date 4/9/23 20:44 PM
 */
public class AdditionalMapExerciseTest {

    /**
     * e.g.
     * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     */
    @Test
    public void learn_ConcurrentHashMap() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
       /**put(K key, V value)**/

       map.put("apple",1);
       map.put("banana",1);
       map.put("orange",1);
       System.out.println(map);

       /**putIfAbsent(K key, V value)**/
       map.putIfAbsent("mango",1);
       System.out.println(map);

       /**putAll(Map<? extends K, ? extends V> m)**/
       ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
       map1.putAll(map);
       System.out.println(map);


    }

    /**
     * e.g.
     * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_IdentityHashMap() {
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();

        /**put(K key, V value)**/
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY,2);

        /**putIfAbsent(K key, V value)**/
        map.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        map.putIfAbsent(DayOfWeek.THURSDAY,4);
        System.out.println(map);

    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    @Test
    public void learn_EnumMap() {
        EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);

        /**put(K key, V value)*/
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);

        /**putIfAbsent(K key, V value)**/
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 3);
        enumMap.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
        System.out.println(enumMap);

    }
}
