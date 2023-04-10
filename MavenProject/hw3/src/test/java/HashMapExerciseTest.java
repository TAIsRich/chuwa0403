import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        map.put("1",1);
        map.putIfAbsent("2", 2);
        Map<String, Integer> mapAdd = new HashMap<>();
        mapAdd.put("3",3);
        map.putAll(mapAdd);

        assertEquals(1, map.get("1").intValue());

        map.getOrDefault("4", 4);

        assertTrue(map.containsKey("1"));

        assertTrue(map.containsValue(1));

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
        Map<String, Integer> map = new HashMap<>();
        map.put("0",0);
        map.put("1",1);
        map.put("2",2);

        map.replace("0",0,3);
        assertEquals(3, map.get("0").intValue());

        map.replace("0",4);
        assertEquals(4, map.get("0").intValue());

        map.replaceAll((key, oldValue) -> oldValue * oldValue);
        assertEquals(4, map.get("2").intValue());

        map.remove("0");
        map.remove("0", 0);

        map.compute("2", (key, val) -> val * 3);
        assertEquals(12, map.get("2").intValue());

        map.computeIfAbsent("0", key -> 4);
        assertEquals(4, map.get("0").intValue());

        map.computeIfPresent("0", (key, value) -> value + value * 10);
        assertEquals(44, map.get("0").intValue());

    }

}
