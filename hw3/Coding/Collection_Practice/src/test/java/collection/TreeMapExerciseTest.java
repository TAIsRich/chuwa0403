package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {

    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
     *
     * containsKey(Object key)
     * containsValue(Object value)
     *
     * keySet()
     * values()
     * isEmpty()
     */
    TreeMap<String, Integer> map;
    @Test
    public void learn_Inserting_And_Retrieving() {
        map = new TreeMap<>();
        map.put("0", 0);
        map.put("1", 1);
        map.putIfAbsent("1", 2);

        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("3", 3);
        map.putAll(map2);

        assertEquals(1, map.get("1"));
        assertEquals("0", map.firstKey());
        assertEquals("3", map.lastKey());

        assumeFalse(map.containsKey("4"));
        assumeTrue(map.containsValue(3));
        assumeFalse(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        map = new TreeMap<>();
        map.put("0", 1);
        assumeTrue(map.replace("0", 1, 0));
        map.replace("0", 2);
        assertEquals(2, map.get("0"));

    }
}
