import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);

        map.putIfAbsent("G", 7);

        ConcurrentHashMap<String, Integer> anotherMap = new ConcurrentHashMap<>();
        anotherMap.put("H", 8);
        anotherMap.put("I", 9);
        map.putAll(anotherMap);
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
        map.put(DayOfWeek.MONDAY, 1);
        map.put(DayOfWeek.TUESDAY, 2);
        map.put(DayOfWeek.WEDNESDAY, 3);

        map.putIfAbsent(DayOfWeek.THURSDAY, 4);
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
        enumMap.put(DayOfWeek.MONDAY, 1);
        enumMap.put(DayOfWeek.TUESDAY, 2);
        enumMap.put(DayOfWeek.WEDNESDAY, 3);

        enumMap.putIfAbsent(DayOfWeek.THURSDAY, 4);
        System.out.println(enumMap);
    }
}