package collection;

import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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
    Map<String, Integer> map;
    @Test
    public void learn_ConcurrentHashMap() {
        map = new ConcurrentHashMap<>();
        map.put("1", 1);
        map.putIfAbsent("1", 2);
        Map<String, Integer> map2 = new HashMap<String, Integer>(){{
            put("2", 2);
        }};
        map.putAll(map2);

        assertEquals(2, map.size());
        assertEquals(1, map.get("1"));
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
        map = new IdentityHashMap<>();
        map.put("1", 1);
        map.put(new String("1"), 2);
        assertEquals(1, map.get("1"));

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
        Map<Days, Integer> map2 = new EnumMap<>(Days.class);
        map2.put(Days.MONDAY, 1);
        map2.putIfAbsent(Days.SUNDAY, 7);

        assertEquals(2, map2.size());

    }
}

enum Days {
    MONDAY, SUNDAY
}
