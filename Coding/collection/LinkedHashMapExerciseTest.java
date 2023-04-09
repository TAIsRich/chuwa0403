
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Instantiate a LinkedHashMap with String keys and Integer values
        Map<String, Integer> map = new LinkedHashMap<>();

        // Insert key-value pairs into the map
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // Test retrieval methods
        assertEquals(1, map.get("apple").intValue());
        assertEquals(2, map.getOrDefault("banana", 0).intValue());
        assertNull(map.get("durian")); // durian is not in the map
        assertTrue(map.containsKey("cherry"));
        assertFalse(map.containsValue(4));

        // Test modifying methods
        map.put("banana", 4); // overwrites previous value for "banana"
        assertEquals(4, map.get("banana").intValue());
        map.putIfAbsent("apple", 5); // does not modify previous value for "apple"
        assertEquals(1, map.get("apple").intValue());

        // Test collection methods
        Set<String> keys = map.keySet();
        assertEquals(3, keys.size());
        assertTrue(keys.contains("banana"));
        Collection<Integer> values = map.values();
        assertEquals(3, values.size());
        assertTrue(values.contains(3));

        // Test clearing the map
        map.clear();
        assertTrue(map.isEmpty());
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
        // Create a HashMap with some key-value pairs
        // Creating a new HashMap and populating it with some elements
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 5);
        map.put("orange", 10);
        map.put("banana", 20);
        System.out.println("Original Map: " + map);

        // Replacing a specific value for a key
        map.replace("orange", 10, 15);
        System.out.println("Map after replacing value for orange: " + map);

        // Replacing a value without specifying the old value
        map.replace("banana", 25);
        System.out.println("Map after replacing value for banana: " + map);

        // Replacing all values in the map using a BiFunction
        map.replaceAll((key, value) -> value * 2);
        System.out.println("Map after replacing all values: " + map);

        // Removing a key-value pair using the key
        map.remove("apple");
        System.out.println("Map after removing apple: " + map);

        // Removing a key-value pair only if the value matches a specific value
        boolean removed = map.remove("banana", 30);
        System.out.println("Map after attempting to remove banana with value 30: " + map);
        System.out.println("Was banana with value 30 removed? " + removed);

        // Computing a new value for a key using a BiFunction
        map.compute("orange", (k, v) -> v + 5);
        System.out.println("Map after computing a new value for orange: " + map);

        // Computing a new value for a key only if it is absent
        map.computeIfAbsent("pear", k -> 8);
        System.out.println("Map after computing value for pear: " + map);

        // Computing a new value for a key only if it is present
        map.computeIfPresent("banana", (k, v) -> v + 10);
        System.out.println("Map after computing value for banana: " + map);
    }
}
