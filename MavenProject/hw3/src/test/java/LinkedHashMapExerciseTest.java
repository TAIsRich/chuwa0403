import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        map.put("1",1);
        map.putIfAbsent("2", 2);

        HashMap<String, Integer> mapAdd = new LinkedHashMap<>();
        mapAdd.put("3",3);
        map.putAll(mapAdd);

        assertEquals(3, map.get("3").intValue());

        map.getOrDefault("4",4);


        assertTrue(map.containsKey("3"));
        assertEquals(true, map.containsValue(3));

        for(String str : map.keySet()){
            //System.out.println(str);
        }

        for(Integer num : map.values()){
            //System.out.println(num);
        }

        assertEquals(false, map.isEmpty());

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
        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);
        map.put("5",5);

        map.replace("1", 1, 6);
        map.replace("1", 7);

        map.replaceAll((key, oldValue) -> oldValue * oldValue);
        map.remove("1");
        map.remove("2", 2);

        map.compute("3", (key, val) -> val * 3);
        map.computeIfAbsent("4", key -> 8);
        map.computeIfPresent("5", (key, value) -> value + value * 10);
    }
}
