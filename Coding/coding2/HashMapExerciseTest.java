import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author b1go
 * @date 6/12/22 4:47 PM
 */
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

    @Test
    public void learn_Inserting_And_Retrieving() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.putIfAbsent("E", 5);

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("F", 6);
        map1.put("G", 7);
        map.putAll(map1);

        int num = map.get("D");
        int defaultNum = map.getOrDefault("A", 1);
        System.out.println(num);
        System.out.println(defaultNum);

        boolean ifHasKey = map.containsKey("B");
        boolean ifHasValue = map.containsValue("C");
        System.out.println(ifHasKey);
        System.out.println(ifHasValue);

        System.out.println(map.keySet());
        System.out.println(map.values());

        boolean ifIsEmpty = map.isEmpty();
        System.out.println(ifHasKey);


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

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        map.replace("A", 1, 111);
        map.replace("C", 55);

        map.replaceAll((key,value) -> value + 1);

        map.remove("D");
        map.remove("C", 4);

        map.compute("A", (key, value) -> value + 1);
        map.computeIfAbsent("E", value -> 5);
        map.computeIfPresent("B", (key, value) -> value + 100);


    }
}