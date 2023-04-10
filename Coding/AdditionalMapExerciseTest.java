package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
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
        //创建偶数的ConcurrentHashMap
        ConcurrentHashMap<String, Integer> evenNumbers = new ConcurrentHashMap<>();

        // 使用 put()
        evenNumbers.put("Two", 2);
        evenNumbers.put("Four", 4);

        // 使用 putIfAbsent()
        evenNumbers.putIfAbsent("Six", 6);
        System.out.println("偶数的ConcurrentHashMap: " + evenNumbers);

        //Creating ConcurrentHashMap of numbers
        ConcurrentHashMap<String, Integer> numbers = new ConcurrentHashMap<>();
        numbers.put("One", 1);

        // 使用 putAll()
        numbers.putAll(evenNumbers);
        System.out.println("ConcurrentHashMap的数字为: " + numbers);

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
        // Creating an empty IdentityHashMap
        Map<Integer, String> identity_hash
                = new IdentityHashMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        identity_hash.put(10, "Geeks");
    }

    /**
     * e.g.
     * EnumMap<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     */
    public enum Hardware
    {
        MONITOR, MOUSE, KEYBOARD;
    }

    @Test
    public void learn_EnumMap() {
        EnumMap<Hardware, String> hardwareMapInstance = new EnumMap<Hardware, String>(Hardware.class);
        /* hardwareMapInstance is empty. Let's populate it. */
        hardwareMapInstance.put(Hardware.MONITOR, "Samsung");
        hardwareMapInstance.put(Hardware.MOUSE, "Logitech g403");
        hardwareMapInstance.put(Hardware.KEYBOARD, "Razer");
    }
}
