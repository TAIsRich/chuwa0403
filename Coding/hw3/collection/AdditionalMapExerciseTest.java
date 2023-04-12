import org.junit.Test;
import java.time.DayOfWeek;
import java.util.concurrent.ConcurrentHashMap;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

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
        // Create a new ConcurrentHashMap
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Test the put method
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map);

        // Test the putIfAbsent method
        map.putIfAbsent("two", 3);
        System.out.println(map);
        map.putIfAbsent("four", 4);
        System.out.println(map);

        // putAll
        ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("one", 2);
        map2.put("two", 3);
        map.putAll(map2);
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
        // Create a new IdentityHashMap
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();

        // Test the put method
        map.put(DayOfWeek.MONDAY, 1);
        System.out.println(map);

        // Test the putIfAbsent method
        map.putIfAbsent(DayOfWeek.MONDAY, 2);
        map.putIfAbsent(DayOfWeek.TUESDAY, 2);
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
        // Test the put method
        enumMap.put(DayOfWeek.MONDAY, 1);
        System.out.println(enumMap);

        // Test the putIfAbsent method
        enumMap.putIfAbsent(DayOfWeek.MONDAY, 2);
        enumMap.putIfAbsent(DayOfWeek.TUESDAY, 2);
        System.out.println(enumMap);
    }
}
