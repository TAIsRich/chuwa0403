package Coding.Collection;
import java.util.*;

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

    TreeMap<Integer, Integer> map = new TreeMap<>();
    public void learn_Inserting_And_Retrieving() {
        map.put(1, 1);
        map.putIfAbsent(2, 2);
        TreeMap<Integer, Integer> map2 = new TreeMap<>();
        map.put(3, 3);
        map.putIfAbsent(4, 4);
        map.putAll(map2);

        map.get(1);
        map.firstKey();
        map.lastKey();

        map.containsKey(1);
        map.containsValue(1);

        map.keySet();
        map.values();
        map.isEmpty();
    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    public void learn_Remove_Replacing_Updating() {
        map.replace(1, 1, 2);
        map.replace(1, 1);

        map.remove(1);
    }
}
