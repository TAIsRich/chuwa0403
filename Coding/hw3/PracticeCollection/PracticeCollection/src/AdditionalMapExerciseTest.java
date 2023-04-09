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

        // Support high concurrency operations
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("abd", 1);
        map.putIfAbsent("abd", 1);

        Map<String, Integer> map2 = new ConcurrentHashMap<>();
        map2.put("qer", 2);
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

        // IdentityHashMap uses "==" to check the key value.
        IdentityHashMap<String, Integer> map = new IdentityHashMap<>();
        String a = "1";
        String b = new String("1");
        String c = new String("1");
        String d = "1";

        map.put(a, 1);
        map.put(b, 1);
        map.putIfAbsent(c, 1);
        map.put(d, 1);

        System.out.println(map.size());
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

        // A map for Enum as key
        Map<DayOfWeek, String> map = new EnumMap<>(DayOfWeek.class);
        map.put(DayOfWeek.MONDAY, "Mon");
        map.putIfAbsent(DayOfWeek.TUESDAY, "Tue");
        map.put(DayOfWeek.WEDNESDAY, "Wed");
        map.put(DayOfWeek.THURSDAY, "Thu");
        map.put(DayOfWeek.FRIDAY, "Fri");
        map.put(DayOfWeek.SATURDAY, "Sat");
        map.put(DayOfWeek.SUNDAY, "Sun");
        System.out.println(map);
        System.out.println(map.get(DayOfWeek.MONDAY));

    }
}
