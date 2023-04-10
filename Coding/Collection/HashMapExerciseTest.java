package Coding.Collection;
import java.util.*;

public class HashMapExerciseTest {

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
    Map<Integer, Integer> map = new HashMap<>();

    public void learn_Inserting_And_Retrieving() {
        map.put(1, 1);
        map.putIfAbsent(2, 2);
        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(1, 1);
        map1.putIfAbsent(2, 2);
        map.putAll(map1);
        map.get(1);
        map.getOrDefault(1, 0);

        map.containsKey(1);
        map.containsValue(1);

        map.keySet();
        map.values();
        map.isEmpty();
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
    
    public void learn_Remove_Replacing_Updating() {
        map.replace(1, 0, 1);
        map.replace(1, 3);

        map.remove(1);
        map.remove(1, 3);

        map.compute(1, (a, b) -> b + 1);
        map.computeIfAbsent(1, k -> 2000 + 33000);
        map.computeIfPresent(1, (a, b) -> b + 1);

    }
}
