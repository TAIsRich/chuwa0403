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
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);

        map.putIfAbsent("G", 7);

        TreeMap<String, Integer> map1 = new TreeMap<>();
        map1.put("H", 8);
        map1.put("I", 9);

        map.putAll(map1);

        System.out.println(map.get("D"));
        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        boolean ifHasA = map.containsKey("A");
        System.out.println(ifHasA);

        boolean ifHasTwo = map.containsValue(2);
        System.out.println(ifHasTwo);

        System.out.println(map.keySet());
        System.out.println(map.values());

        boolean ifIsEmpty = map.isEmpty();
        System.out.println(ifIsEmpty);




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
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        map.put("F", 6);

        map.replace("A", 1, 111);
        map.replace("B", 222);
        map.remove("E");

    }
}

