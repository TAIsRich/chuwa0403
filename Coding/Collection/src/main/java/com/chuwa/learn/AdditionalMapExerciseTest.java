package com.chuwa.learn;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class AdditionalMapExerciseTest {

        /**
         * e.g.
         * ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
         * <p>
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         * putAll(Map<? extends K, ? extends V> m)
         */
        @Test
        public void learn_ConcurrentHashMap() {
                ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
                map.put("one", 1);
                map.putIfAbsent("two", 2);
                ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
                map2.put("three", 3);
                map.putAll(map2);
                System.out.println(map);
        }

        /**
         * e.g.
         * Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
         * <p>
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         */
        @Test
        public void learn_IdentityHashMap() {
                Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
                map.put(DayOfWeek.MONDAY, 1);
                map.put(DayOfWeek.TUESDAY, 2);
                map.putIfAbsent(DayOfWeek.WEDNESDAY, 3);
                System.out.println(map);
        }

        /**
         * e.g.
         * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
         * <p>
         * put(K key, V value)
         * putIfAbsent(K key, V value)
         */
        @Test
        public void learn_EnumMap() {
                EnumMap<DayOfWeek,Integer> enumMap = new EnumMap<>(DayOfWeek.class);
                enumMap.put(DayOfWeek.MONDAY,1);
                enumMap.putIfAbsent(DayOfWeek.TUESDAY,2);
                System.out.println(enumMap);
        }

}


