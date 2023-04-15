package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
public class LinkedHashMapExerciseTest {
    /**
     * e.g.
     * HashMap<String, Integer> map = new LinkedHashMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */
    Map<String, Integer> map;
    @Test
    public void learn_Inserting_And_Retrieving() {
        map = new LinkedHashMap<String, Integer>() {{
            put("1", 1);
            putIfAbsent("2", 2);
            put("3", 3);
        }};

        Map<String, Integer> map2 = new LinkedHashMap<>(map);
        map2.putIfAbsent("0", 0);
        map.putAll(map2);

        assertEquals(0, map.get("0"));
        assertEquals(0, map.getOrDefault("10", 0));
        assumeTrue(map.containsKey("2"));
        assumeTrue(map.containsValue(3));

        System.out.println(map.keySet());
        System.out.println(map.values());
        assumeFalse(map.isEmpty());

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     * replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
     *
     * remove(Object key)
     * remove(Object key, Object value)
     *
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        map = new LinkedHashMap<String, Integer>(){{
            put("0", 0);
            put("1", 2);
        }};

        assumeTrue(map.replace("1", 2, 1));

        map.replace("0", 2);
        assertEquals(2, map.get("0"));

        map.remove("0");
        assumeTrue(map.remove("1", 1));

        map.put("5", 1);
        map.compute("5", (key, value) -> value * 5);
        assertEquals(5, map.get("5"));

    }
}
