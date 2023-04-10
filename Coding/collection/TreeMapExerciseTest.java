package Coding.collection;

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
        map.put("charlie", 1);
        map.put("david", 2);
        map.putIfAbsent("david", 2);

        Map<String, Integer> newMap = new HashMap<>();
        map.put("mike", 1);
        map.put("jojo", 2);
        map.putAll(newMap);

        map.get("charlie");
        map.getOrDefault("sisi", 1);

        map.containsKey("charlie");
        map.containsValue(5);

        for (String str : map.keySet())
            System.out.println(str);

        for (int num : map.values())
            System.out.println(num);
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
        map.put("charlie", 1);
        map.put("david", 2);

        map.replace("charlie", 5);
        map.remove("david");

        System.out.println(map);
    }
}
