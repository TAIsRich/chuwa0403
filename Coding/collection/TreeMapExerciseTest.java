
import org.junit.Test;

import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

import static org.junit.Assert.*;

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

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a new TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // Use put method to insert key-value pairs into the map
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        // Use get method to retrieve the value associated with a key
        assertEquals(Integer.valueOf(30), map.get("Bob"));

        // Use firstKey method to retrieve the first (lowest) key in the map
        assertEquals("Alice", map.firstKey());

        // Use lastKey method to retrieve the last (highest) key in the map
        assertEquals("Charlie", map.lastKey());

        // Use containsKey method to check if the map contains a key
        assertTrue(map.containsKey("Bob"));

        // Use containsValue method to check if the map contains a value
        assertTrue(map.containsValue(35));

        // Use keySet method to retrieve a set of keys in the map
        Set<String> keySet = map.keySet();
        assertEquals(3, keySet.size());
        assertTrue(keySet.contains("Alice"));
        assertTrue(keySet.contains("Bob"));
        assertTrue(keySet.contains("Charlie"));

        // Use values method to retrieve a collection of values in the map
        Collection<Integer> values = map.values();
        assertEquals(3, values.size());
        assertTrue(values.contains(25));
        assertTrue(values.contains(30));
        assertTrue(values.contains(35));

        // Use isEmpty method to check if the map is empty
        assertFalse(map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("Alice", 23);
        map.put("Bob", 28);
        map.put("Charlie", 32);
        System.out.println("Original Map: " + map);

        // remove key-value pair
        map.remove("Bob");
        System.out.println("After removing Bob: " + map);

        // replace value for a key
        map.replace("Alice", 25);
        System.out.println("After replacing Alice's value: " + map);

        // replace value for a key only if current value matches
        map.replace("Charlie", 32, 35);
        System.out.println("After replacing Charlie's value: " + map);
    }
}
