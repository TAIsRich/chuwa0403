package com.chuwa.exercise.collection;

import org.junit.Test;
import java.util.TreeMap;


/**
 * @author Min He
 * @date 4/9/23 20:41 PM
 */
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
        TreeMap<String,Integer> map= new TreeMap<>();

        /** put(K key, V value)**/
        map.put("abb",2);
        map.put("ab",4);
        map.put("ca",6);
        System.out.println(map);

        /**putIfAbsent(K key, V value)**/
        map.putIfAbsent("ba",3);
        map.putIfAbsent("da",1);
        System.out.println(map);

        /**putAll(Map<? extends K, ? extends V> m)**/
        TreeMap<String,Integer> map1= new TreeMap<>();
        map1.putAll(map);
        System.out.println(map1);

        /**get(Object key)**/
        int val = map.get("abb");
        System.out.println(val);

        /**firstKey()&lastKey()**/

        System.out.println(map.firstKey());
        System.out.println(map.lastKey());

        /**containsKey(Object key) & containsValue(Object value)**/
        System.out.println(map.containsKey("ab"));
        System.out.println(map.containsValue(7));

        /**keySet()**/
        for(String key : map.keySet()){
            System.out.print(key + " ");
        }

        /**values()**/
        for(int num : map.values()){
            System.out.print(num + " ");
        }

        /**isEmpty()**/
        System.out.print(map.isEmpty());

    }

    /**
     * replace(K key, V oldValue, V newValue)
     * replace(K key, V value)
     *
     * remove(Object key)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        TreeMap<String,Integer> map= new TreeMap<>();

        map.put("abb",2);
        map.put("ab",4);
        map.put("ca",6);
        System.out.println(map);

        /**replace(K key, V oldValue, V newValue)**/
        boolean repalce = map.replace("abb",2,10);
        System.out.println(repalce);
        System.out.println(map);

        /**replace(K key, V value)**/
        Integer oldValue = map.replace("ca",40);
        System.out.println(oldValue);
        System.out.println(map);

        /**remove(Object key) **/
        System.out.println(map.remove("abb"));
        System.out.println(map.remove("ab",2));
        System.out.println(map.remove("ab",4));
        System.out.println(map);
    }
}
