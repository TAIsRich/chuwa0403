package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class AdditionalMapExerciseTest {
    enum Weekday {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
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
        map.put("123",123);
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.putAll(map);
        System.out.println(map2);
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
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        String key1 = new String("hello");
        String key2 = new String("hello");
        Integer value1 = 1;
        Integer value2 = 2;

        map.put(key1, value1);
        map.put(key2, value2);

        System.out.println(map.size()); // Output: 2
        System.out.println(map.get(key1)); // Output: 1
        System.out.println(map.get(key2)); // Output: 2
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

        EnumMap<Weekday, String> schedule = new EnumMap<>(Weekday.class);

        schedule.put(Weekday.MONDAY, "Gym");
        schedule.put(Weekday.TUESDAY, "Work");
        schedule.put(Weekday.WEDNESDAY, "Meetings");
        schedule.put(Weekday.THURSDAY, "Work");
        schedule.put(Weekday.FRIDAY, "Date night");
        schedule.put(Weekday.SATURDAY, "Hiking");
        schedule.put(Weekday.SUNDAY, "Relaxing");

        System.out.println(schedule.get(Weekday.MONDAY)); // Output: Gym
        System.out.println(schedule.get(Weekday.FRIDAY)); // Output: Date night
    }
}
