import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

        Map<String, Integer> map = new LinkedHashMap<>() {{
            put("a", 1);
            put("b", 2);
        }};
        System.out.println(map);

        Map<String, Integer> map1 = new HashMap<>() {{
            put("d", 4);
        }};

        map.putIfAbsent("c", 3);
        System.out.println(map);

        map.putAll(map1);
        System.out.println(map);

        System.out.println(map.get("a"));
        System.out.println(map.getOrDefault("e", -1));

        System.out.println(map.containsKey("a"));

        System.out.println(map.containsValue(5));

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.size());

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

        HashMap<String, Integer> map = new LinkedHashMap<>() {{
            put("a", 1);
            put("b", 1);
            put("c", 2);
            put("d", 4);
        }};
        System.out.println(map);

        map.replace("a", 10);
        System.out.println(map);

        map.replaceAll((k, v) -> v + 1);
        System.out.println(map);

        map.remove("d");
        System.out.println(map);

        map.compute("a", (k, v) -> v - 10);
        System.out.println(map);

        map.computeIfAbsent("e", v -> 4);
        System.out.println(map);

        map.computeIfPresent("b", (k, v) -> v + 10);
        System.out.println(map);

    }
}
