import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HashMapExerciseTest {

    /**
     * e.g.
     * Map<String, Integer> map = new HashMap<>();
     * <p>
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     * <p>
     * get(Object key)
     * getOrDefault(Object key, V defaultValue)
     * <p>
     * containsKey(Object key)
     * containsValue(Object value)
     * <p>
     * keySet()
     * values()
     * isEmpty()
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("pear", 2);
        map.putIfAbsent("apple", 2);

        Map<String, Integer> newMap = new HashMap<>();
        map.put("melon", 1);
        map.put("tangerine", 2);
        map.putAll(newMap);

        map.get("apple");
        map.getOrDefault("grape", 1);

        map.containsKey("melon");
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
     * <p>
     * remove(Object key)
     * remove(Object key, Object value)
     * <p>
     * compute(Key, BiFunction)
     * computeIfAbsent(Key, Function)
     * computeIfPresent(Key, BiFunction)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

    }
}