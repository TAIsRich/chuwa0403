package Coding.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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
        map.put("english", 1);
        map.put("french", 2);
        map.putIfAbsent("english", 2);

        Map<String, Integer> newMap = new HashMap<>();
        map.put("chinese", 1);
        map.put("japanse", 2);
        map.putAll(newMap);

        map.get("english");
        map.getOrDefault("italian", 1);

        map.containsKey("english");
        map.containsValue(5);

        for (String str : map.keySet())
            System.out.println(str);

        for (int num : map.values())
            System.out.println(num);
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("english", 1);
        map.put("french", 2);
        map.put("chinese", 3);
        map.putIfAbsent("english", 2);

        map.replace("english", 10);
        map.remove("chinese");
    }
}
