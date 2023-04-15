package CollectionsTest;


import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("Key", 0);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("key2", 2);
        map.putAll(map2);

        //get
        System.out.println(map.get("key1"));
        System.out.println(map.getOrDefault("key3", 3));

        //contains
        System.out.println(map.containsKey("key1"));
        System.out.println(map.containsValue(2));

        //keySet
        System.out.println(map.keySet());

        //values
        System.out.println(map.values());

        //isEmpty
        System.out.println(map.isEmpty());


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
        //replace
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("Key", 0);
        map.put("key2", 2);
        map.replace("key1", 1, 3);
        map.replace("key2", 2);
        System.out.println(map);

        //remove
        map.remove("key1");
        map.remove("key2", 2);
        System.out.println(map);

        //compute
        map.compute("key1", (k, v) -> v == null ? 1 : v + 1);
        map.put("key2", 2);
        map.put("key3", 3);
        map.put("key4", 4);
        map.compute("key2", (k, v) -> v == null ? 1 : v + 1);
        System.out.println(map);
    }
}
