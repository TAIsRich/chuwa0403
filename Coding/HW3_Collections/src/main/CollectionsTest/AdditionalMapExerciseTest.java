package CollectionsTest;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


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
        ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
        map1.put("key1", 1);
        map1.putIfAbsent("Key", 0);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key2", 2);

        map1.putAll(map2);

        //test 2 maps
        System.out.println(map1.containsValue(2));
        System.out.println(map2.get("key2"));
        System.out.println(map1.getOrDefault("key3", 3));

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
        Map<String, Integer> map1 = new IdentityHashMap<>();
        map1.put("key1", 1);
        map1.putIfAbsent("Key", 0);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key2", 2);

        map1.putAll(map2);

        //test 2 maps
        System.out.println(map1.containsValue(2));
        System.out.println(map2.get("key2"));
        System.out.println(map2.get("key0"));
        System.out.println(map1.getOrDefault("key3", 3));

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
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 0);

        //test 2 maps
        System.out.println(enumMap.containsValue(1));
        System.out.println(enumMap.get(DayOfWeek.MONDAY));
        System.out.println(enumMap.getOrDefault(DayOfWeek.SUNDAY, 7));


    }
}