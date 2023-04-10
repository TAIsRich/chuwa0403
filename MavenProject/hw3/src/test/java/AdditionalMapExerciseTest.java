import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.util.EnumMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

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
        /**
         ConcurrentHashMap is a thread-safe implementation of the Map interface in Java,
         which means multiple threads can access it simultaneously without any synchronization issues.
         */
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("1", 1);
        map.putIfAbsent("2", 2);

        ConcurrentHashMap<String, Integer> mapAdd = new ConcurrentHashMap<>();
        mapAdd.put("3", 3);
        map.putAll(mapAdd);

        assertEquals(3, map.size());
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
        /**
         *
         IdentityHashMap allows mutable keys.
         This is why general Map objects mandate immutable objects as a key.
         Interestingly, IdentityHashMap is able to retrieve values even when the key object has been modified.
         In the above code, assertEquals ensures that the same text is retrieved again.
         */
        DayOfWeek mon = DayOfWeek.MONDAY;
        DayOfWeek tue = DayOfWeek.TUESDAY;
        DayOfWeek fri = DayOfWeek.FRIDAY;
        Map<DayOfWeek, Integer> map = new IdentityHashMap<>();
        map.put(mon, 1);
        map.put(tue, 2);
        map.putIfAbsent(fri, 3);

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
        /**
        In short, EnumMap is best suited for enum keys,
         for which it has optimized and performed better than HashMap in Java.
         Use EnumMap whenever you can use enum as keys.
         */

        Map<DayOfWeek, Integer> enumMap = new EnumMap<>(DayOfWeek.class);
        DayOfWeek mon = DayOfWeek.MONDAY;
        DayOfWeek tue = DayOfWeek.TUESDAY;
        enumMap.put(mon, 1);
        enumMap.putIfAbsent(tue, 2);
    }
}
