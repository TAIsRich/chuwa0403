import org.junit.Test;

import java.security.spec.RSAOtherPrimeInfo;
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
        map.put("b", 1);
        map.putIfAbsent("a", 2);
        System.out.println(map);

        Map<String, Integer> x = new TreeMap<>() {{
            put("e", 3);
            put("d", 4);
            put("c", 5);
        }};
        map.putAll(x);
        System.out.println(map);

        System.out.println(map.get("e"));

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        System.out.println(map.containsKey("a"));
        System.out.println(map.containsValue(6));

        System.out.println(map.keySet());
        System.out.println(map.values());
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

        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("b", 1);
        map.putIfAbsent("a", 2);
        System.out.println(map);

        map.replace("a", 0);
        System.out.println(map);

        map.remove("b");
        System.out.println(map);
    }
}
