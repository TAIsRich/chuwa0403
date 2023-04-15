package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
        map = new HashMap<>();
        map.put("1", 1);
        map.putIfAbsent("1", 2);

        Map<String, Integer> map2 = new HashMap<String, Integer>(){{
            put("2", 2);
            put("3", 3);
        }};
        map.putAll(map2);

        assertEquals(1, map.get(("1")));
        assertEquals(0, map.getOrDefault("4", 0));
        assumeTrue(map.containsKey("3"));
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
        map = new HashMap<String, Integer>() {{
            put("0", 1);
            put("1", 2);
        }};

        map.replace("0", 0);
        assertEquals(0, map.get("0"));

        assumeTrue(map.replace("1", 2, 1));

        map.replaceAll((key, value) -> value + 1);
        assertEquals(1, map.get("0"));
        assertEquals(2, map.get("1"));

        map.remove("0");
        assumeTrue(map.remove("1", 2));
        assumeTrue(map.isEmpty());

        map.put("0", 0);
        map.compute("0", (key, value) -> value + 1);
        assertEquals(1, map.get("0"));


    }
}
