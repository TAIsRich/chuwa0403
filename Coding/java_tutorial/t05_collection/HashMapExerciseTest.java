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
        Map<String, Integer> map = new HashMap<>();

        // put method - adds an entry to the map
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);
        System.out.println(map);

        // putIfAbsent method - adds an entry to the map only if the key is not already present
        map.putIfAbsent("Apple", 4);
        System.out.println(map);

        // putAll method - adds all entries from another map
        Map<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("Grape", 4);
        anotherMap.put("Mango", 5);
        map.putAll(anotherMap);
        System.out.println(map);

        // get method - retrieves the value for a given key
        Integer appleValue = map.get("Apple");
        System.out.println("Apple: " + appleValue);

        // getOrDefault method - retrieves the value for a given key, or a default value if the key is not present
        Integer pearValue = map.getOrDefault("Pear", 0);
        System.out.println("Pear: " + pearValue);

        // containsKey method - checks if the map contains a given key
        boolean hasBanana = map.containsKey("Banana");
        System.out.println("Has Banana: " + hasBanana);

        // containsValue method - checks if the map contains a given value
        boolean hasValueThree = map.containsValue(3);
        System.out.println("Has Value Three: " + hasValueThree);

        // keySet method - returns a set of all keys in the map
        Set<String> keys = map.keySet();
        System.out.println("Keys: " + keys);

        // values method - returns a collection of all values in the map
        Collection<Integer> values = map.values();
        System.out.println("Values: " + values);

        // isEmpty method - checks if the map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println("Is Empty: " + isEmpty);
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
        map.put("Apple", 2);
        map.put("Banana", 3);
        map.put("Orange", 4);

        // Replace an existing value
        map.replace("Apple", 2, 5);
        System.out.println("After replace(): " + map);

        // Replace a value without checking the old value
        map.replace("Banana", 6);
        System.out.println("After replace(): " + map);

        // Replace all values in the Map using a BiFunction
        map.replaceAll((k, v) -> v + 1);
        System.out.println("After replaceAll(): " + map);

        // Remove a key-value pair from the Map
        map.remove("Orange");
        System.out.println("After remove(): " + map);

        // Remove a key-value pair only if the key maps to the specified value
        map.remove("Banana", 7);
        System.out.println("After remove(): " + map);

        // Compute a new value for a key using a BiFunction
        map.compute("Apple", (k, v) -> v + 2);
        System.out.println("After compute(): " + map);

        // Compute a new value for a key only if it is absent
        map.computeIfAbsent("Grapes", k -> 5);
        System.out.println("After computeIfAbsent(): " + map);

        // Compute a new value for a key only if it is present
        map.computeIfPresent("Banana", (k, v) -> v + 2);
        System.out.println("After computeIfPresent(): " + map);
    }
}
