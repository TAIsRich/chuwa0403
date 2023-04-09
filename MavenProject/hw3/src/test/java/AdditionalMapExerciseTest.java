import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

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
        map.put("a", 1);
        map.putIfAbsent("a", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 2);

        map.putAll(map2);
        assertEquals(1, map.get("a").intValue());
        assertEquals(-1, map.getOrDefault("c", -1).intValue());
        assertTrue(map.containsKey("a"));
        assertTrue(map.containsValue(2));
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
        Map<String, Integer> map = new IdentityHashMap<>();
        map.put("a", 1);
        map.putIfAbsent("a", 2);
        assertEquals(1, map.get("a").intValue());
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
        enumMap.put(DayOfWeek.SATURDAY, 1);
        enumMap.putIfAbsent(DayOfWeek.SUNDAY, 2);
        assertEquals(1, enumMap.get(DayOfWeek.SATURDAY).intValue());
    }
}