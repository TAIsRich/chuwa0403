import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class HashMapExerciseTest {
    Map<String, Integer> map = new HashMap<>();

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

    @Test
    public void learn_Inserting_And_Retrieving() {
        map.put("a", 1);
        map.putIfAbsent("a", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("b", 2);

        map.putAll(map2);
        assertEquals(1, map.get("a").intValue());
        assertEquals(-1, map.getOrDefault("c", -1).intValue());
        assertTrue(map.containsKey("a"));
        assertTrue(map.containsValue(2));

        assertEquals(2, map.keySet().size());
        assertEquals(2, map.values().size());
        assertFalse(map.isEmpty());
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
        map.clear();
        map.put("a", 1);
        map.put("b", 2);
        map.replace("a", 1, 2);
        map.replace("b", 3);
        map.replaceAll((a, b) -> b + 1);
        assertEquals(3, map.get("a").intValue());
        assertEquals(4, map.get("b").intValue());

        map.compute("a", (a, b) -> b + 1);
        map.computeIfAbsent("c", k -> 120);
        map.computeIfPresent("a", (a, b) -> b + 1);
        map.remove("a");
        map.remove("b");
        map.remove("c");
        assertTrue(map.isEmpty());
    }
}