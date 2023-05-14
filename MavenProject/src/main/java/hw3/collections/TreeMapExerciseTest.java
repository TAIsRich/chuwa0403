package hw3.collections;

import org.junit.Test;

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

        map.put("a", 0); map.put("b", 0);map.put("c", 0);map.put("d", 30);
        map.putIfAbsent("e", 90);

        System.out.println(map.get("a"));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(30));

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.size());
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

        map.put("a", 0); map.put("b", 0);map.put("c", 0);map.put("d", 30);
        map.replace("a", 9);
        map.remove("a");
        System.out.println(map);

    }
}

