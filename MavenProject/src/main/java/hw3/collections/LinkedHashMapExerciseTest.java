package hw3.collections;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;


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

        map.put("a", 0); map.put("b", 0);map.put("c", 0);map.put("d", 30);
        map.putIfAbsent("a",10);
        System.out.println(map);
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("b", 90);
        map.putAll(map2);


        System.out.println(map.get("b"));
        System.out.println(map.getOrDefault("f", 10));

        System.out.println(map.containsKey("f"));
        System.out.println(map.containsValue("b"));

        System.out.println(map.keySet());
        System.out.println(map.values());
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

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 0); map.put("b", 0);map.put("c", 0);map.put("d", 30);
        map.replace("a", 0, 8);
        map.replaceAll((k,v) -> v + 1);
        System.out.println(map);

        map.remove("a");
        map.remove("b", 0);
        System.out.println(map);

        map.compute("c", (k, v) -> v + 10);
        map.computeIfAbsent("f", k -> 90);
        map.computeIfPresent("d", (k, v) -> v + 10);
        System.out.println(map);

    }
}