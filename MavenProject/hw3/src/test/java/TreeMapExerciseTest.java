import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

public class TreeMapExerciseTest {
    /**
     * e.g.
     * TreeMap<String, Integer> map = new TreeMap<>();
     *
     * put(K key, V value)
     * putIfAbsent(K key, V value)
     * putAll(Map<? extends K, ? extends V> m)
     *
     * get(Object key)
     * firstKey()
     * lastKey()
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
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("1",1);
        map.putIfAbsent("2", 2);

        TreeMap<String, Integer> mapAdd = new TreeMap<>();
        mapAdd.put("3",3);
        map.putAll(mapAdd);

        map.get("3");
        map.firstKey();
        map.lastKey();

        map.containsKey("1");
        map.containsValue(1);

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
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String, Integer> map = new TreeMap<>();
        map.put("1",1);
        map.put("2",2);

        map.replace("1", 1,0);
        map.replace("1", -1);

        map.remove("2");
    }
}
