
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    @Test
    public void learn_Inserting_And_Retrieving() {
        // Creating a HashMap
        Map<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the map
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Retrieving values from the map using key
        int value1 = map.get("Apple");
        int value2 = map.get("Banana");
        int value3 = map.getOrDefault("Mango", 4);

        // Checking if the map contains the given key or value
        boolean keyExists = map.containsKey("Apple");
        boolean valueExists = map.containsValue(2);

        // Retrieving keys or values from the map as Set
        Set<String> keys = map.keySet();
        Collection<Integer> values = map.values();

        // Checking if the map is empty
        boolean isEmpty = map.isEmpty();
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
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);

        // replace()
        map.replace("Banana", 20, 25); // replaces value 20 with 25 for key "Banana"
        map.replace("Orange", 35); // replaces value of key "Orange" with 35

        // replaceAll()
        map.replaceAll((key, value) -> value + 5); // adds 5 to each value in the map

        // remove()
        map.remove("Banana"); // removes the entry with key "Banana"
        map.remove("Apple", 10); // removes the entry with key "Apple" only if its value is 10

        // compute()
        map.compute("Orange", (key, value) -> value == null ? 0 : value + 10); // adds 10 to the value of key "Orange"
        map.compute("Grapes", (key, value) -> value == null ? 5 : value + 5); // adds entry with key "Grapes" and value 5 if it doesn't exist

        // computeIfAbsent()
        map.computeIfAbsent("Pear", key -> 15); // adds entry with key "Pear" and value 15 if it doesn't exist

        // computeIfPresent()
        map.computeIfPresent("Orange", (key, value) -> value + 5); // adds 5 to the value of key "Orange" only if it exists

        System.out.println(map); // prints the updated map
    }
}
