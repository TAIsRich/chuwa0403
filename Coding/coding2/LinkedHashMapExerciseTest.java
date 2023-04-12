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
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        map.putIfAbsent("E", 5);

        HashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("E", 5);
        map1.put("F", 6);
        map1.putAll(map1);

        map.get("A");
        map.getOrDefault("B", 1);

        boolean ifHasC = map.containsKey("C");
        boolean ifHasFour = map.containsValue("4");
        System.out.println(ifHasC);
        System.out.println(ifHasFour);
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
        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        map.replace("A", 1, 111);
        map.replace("C", 55);
        map.replaceAll((key, value) -> value + 1);

        map.remove("D");
        map.remove("A", 2);

        map.compute("B", (key,value) -> value + 1);
        map.computeIfAbsent("E", key -> 5);
        map.computeIfPresent("C", (key, value) -> value + 2);








    }
}