package CollectionsTest;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
public class TreeMapExerciseTest {
    public TreeMap<String, Integer> map = new TreeMap<>();

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
        // PUT
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.putIfAbsent("a", 6);
        map.putIfAbsent("f", 7);
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("g", 8);
        map2.put("h", 9);

        map.putAll(map2);
        System.out.println(map);

        // GET
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        //firstKey
        System.out.println(map.firstKey());
        //lastKey
        System.out.println(map.lastKey());

        // CONTAINS
        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(1));

        // KEYSET
        System.out.println(map.keySet());

        // VALUES
        System.out.println(map.values());

        // IS EMPTY
        System.out.println(map.isEmpty());


    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        map.put("e", 5);
        map.putIfAbsent("a", 6);
        map.putIfAbsent("f", 7);
        TreeMap<String, Integer> map2 = new TreeMap<>();
        map2.put("g", 8);
        map2.put("h", 9);

        map.putAll(map2);
        System.out.println(map);

        // REPLACE
        map.replace("a", 1, 6);
        map.replace("b", 2);
        System.out.println(map);

        // REMOVE
        map.remove("a");
        System.out.println(map);

    }
}
