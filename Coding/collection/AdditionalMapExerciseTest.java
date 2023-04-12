
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("one", 1);
        map.putIfAbsent("two", 2);
        Map<String, Integer> otherMap = new HashMap<>();
        otherMap.put("three", 3);
        otherMap.put("four", 4);
        map.putAll(otherMap);

        assertEquals(4, map.size());
        assertEquals(1, map.get("one").intValue());
        assertEquals(2, map.get("two").intValue());
        assertEquals(3, map.get("three").intValue());
        assertEquals(4, map.get("four").intValue());

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
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek anotherMonday = DayOfWeek.of(1);

        map.put(monday, 1);
        map.putIfAbsent(anotherMonday, 2);

        assertEquals(1, map.size());
        assertEquals(1, map.get(monday).intValue());
        assertEquals(1, map.get(anotherMonday).intValue());

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
        DayOfWeek monday = DayOfWeek.MONDAY;
        DayOfWeek tuesday = DayOfWeek.TUESDAY;

        enumMap.put(monday, 1);
        enumMap.putIfAbsent(tuesday, 2);

        assertEquals(2, enumMap.size());
        assertEquals(1, enumMap.get(monday).intValue());
        assertEquals(2, enumMap.get(tuesday).intValue());

    }
}
