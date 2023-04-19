import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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

    @Test
    public void learn_Inserting_And_Retrieving() {
        TreeMap<String, Integer> map = new TreeMap<>();

        // inserting
        map.put("Alice", 25);
        map.putIfAbsent("Bob", 30);
        Map<String, Integer> additionalMap = new HashMap<>();
        additionalMap.put("Charlie", 35);
        additionalMap.put("David", 40);
        map.putAll(additionalMap);
        System.out.println("Map after inserting: " + map);

        // retrieving
        System.out.println("Value for key 'Alice': " + map.get("Alice"));
        System.out.println("First key in map: " + map.firstKey());
        System.out.println("Last key in map: " + map.lastKey());

        System.out.println("Does map contain key 'Bob'?: " + map.containsKey("Bob"));
        System.out.println("Does map contain value 35?: " + map.containsValue(35));
        System.out.println("Key set of map: " + map.keySet());
        System.out.println("Values in map: " + map.values());
        System.out.println("Is map empty?: " + map.isEmpty());
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        // Create a TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // Insert elements
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);

        System.out.println("Initial TreeMap: " + map);

        // Replace an existing value
        map.replace("Bob", 4);
        System.out.println("TreeMap after replacing 'Bob': " + map);

        // Replace an existing key-value pair
        map.replace("Charlie", 35, 5);
        System.out.println("TreeMap after replacing 'Charlie' with '5': " + map);

        // Remove an element
        map.remove("Alice");
        System.out.println("TreeMap after removing 'Alice': " + map);
    }
}
