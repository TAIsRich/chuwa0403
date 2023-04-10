import org.junit.Test;

import java.util.*;

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
        // create a new HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // add key-value pairs
        map.put("apple", 2);
        map.put("banana", 5);
        map.put("cherry", 8);
        System.out.println(map);

        // add a key-value pair only if the key is not already present
        map.putIfAbsent("banana", 10);
        System.out.println(map);

        // add multiple key-value pairs from another map
        HashMap<String, Integer> anotherMap = new HashMap<>();
        anotherMap.put("pear", 3);
        anotherMap.put("kiwi", 6);
        map.putAll(anotherMap);
        System.out.println(map);

        // get the value for a key
        System.out.println(map.get("apple"));

        // get the value for a key, or a default value if the key is not present
        System.out.println(map.getOrDefault("orange", 0));

        // check if a key is present in the map
        System.out.println(map.containsKey("banana"));

        // check if a value is present in the map
        System.out.println(map.containsValue(8));

        // get the set of keys in the map
        Set<String> keys = map.keySet();
        System.out.println(keys);

        // get the collection of values in the map
        Collection<Integer> values = map.values();
        System.out.println(values);

        // check if the map is empty
        boolean isEmpty = map.isEmpty();
        System.out.println(isEmpty);
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
        // Create a new HashMap
        Map<String, Integer> map = new HashMap<>();

        // Add some key-value pairs to the map
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println(map);

        // replace(K key, V oldValue, V newValue)
        map.replace("B", 2, 22);
        System.out.println(map);

        // replace(K key, V value)
        map.replace("C", 33);
        System.out.println(map);

        // replaceAll(BiFunction<? super K, ? super V, ? extends V> function)
        map.replaceAll((k, v) -> v * 2);
        System.out.println(map);

        // remove(Object key)
        map.remove("B");
        System.out.println(map);

        // remove(Object key, Object value)
        map.remove("C", 6);
        System.out.println(map);

        // compute(Key, BiFunction)
        map.compute("A", (k, v) -> v + 10);
        System.out.println(map);

        // computeIfAbsent(Key, Function)
        map.computeIfAbsent("D", k -> 4);
        System.out.println(map);

        // computeIfPresent(Key, BiFunction)
        map.computeIfPresent("B", (k, v) -> v - 5);
        System.out.println(map);
    }
}
