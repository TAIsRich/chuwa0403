package CollectionsTest;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapExerciseTest {
    Map<String, Integer> map = new HashMap<>();
    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
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
        map.put("key1", 1);
        map.putIfAbsent("Key", 0);
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("key2", 2);
        map.putAll(map2);

        // GET
        System.out.println(map.get("key1"));
        System.out.println(map.getOrDefault("key3", 3));

        // CONTAINS
        System.out.println(map.containsKey("key1"));
        System.out.println(map.containsValue(2));

        // KEYSET
        System.out.println(map.keySet());

        // VALUES
        System.out.println(map.values());

        // IS EMPTY
        Map<String, Integer> map3 = new HashMap<>();
        System.out.println(map3.isEmpty());


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
        map.put("key1", 1);
        map.put("key2", 2);
        map.replace("key1", 1, 3);
        //replaceAll
        map.replaceAll((k, v) -> v + 1);
        System.out.println(map);

        //remove
        map.remove("key1");
        map.remove("key2", 3);
        System.out.println(map);

        //compute
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 11);
        map.put("key4", 22);
        map.compute("key1", (k, v) -> v + 1);
        map.computeIfAbsent("key2", k -> 2);
        map.computeIfPresent("key2", (k, v) -> v + 1);
        System.out.println(map);


    }
}
