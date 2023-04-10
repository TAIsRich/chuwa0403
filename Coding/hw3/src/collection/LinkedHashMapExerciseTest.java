package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author Min He
 * @date 4/9/23 19:57 PM
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

        /** put(K key, V value)**/
        map.put("app",1);
        map.put("bpp",2);
        map.put("cpp",1);
        System.out.println(map);

        /**putIfAbsent(K key, V value)**/
        map.putIfAbsent("app",3);
        map.putIfAbsent("dpp",1);
        System.out.println(map);

        /**putAll(Map<? extends K, ? extends V> m)**/
        HashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.putAll(map);
        System.out.println(map1);

        /**get(Object key)**/
        int value = map.get("app");
        System.out.println(value);

        /**getOrDefault(Object key, V defaultValue)**/
        int value1 = map.getOrDefault("bpp",0);
        int value2 = map.getOrDefault("epp",0);
        System.out.println(value1);
        System.out.println(value2);

        /**containsKey(Object key) & containsValue(Object value)**/
        System.out.println(map.containsKey("app"));
        System.out.println(map.containsValue(6));

        /**keySet()**/
        for(String key : map.keySet()){
            System.out.print(key + " ");
        }

        /**values()**/
        for(int val : map.values()){
            System.out.print(val + " ");
        }

        /** isEmpty()**/
        System.out.print(map.isEmpty());
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
        HashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("app",1);
        map1.put("bpp",2);
        map1.put("cpp",1);
        System.out.println(map1);

        /**replace(K key, V oldValue, V newValue)**/
       boolean repalce = map1.replace("app",1,3);
       System.out.println(repalce);
       System.out.println(map1);

        /**replace(K key, V value)**/
        Integer oldValue = map1.replace("bpp",4);
        System.out.println(oldValue);
        System.out.println(map1);

        /**replaceAll(BiFunction<? super K, ? super V, ? extends V> function)**/
        map1.replaceAll((key,value)->value + 10);
        System.out.println(map1);

        /**remove(Object key) &&remove(Object key, Object value) **/
        System.out.println(map1.remove("app"));
        System.out.println(map1.remove("bpp",2));
        System.out.println(map1.remove("bpp",14));
        System.out.println(map1);

        /**compute(Key, BiFunction)**/
        map1.compute("cpp", (key, value) -> value + 10);
        System.out.println(map1);

        /** computeIfAbsent(Key, Function)**/
        map1.computeIfAbsent("dpp",key-> map1.size());
        System.out.println(map1);

        /**computeIfPresent(Key, BiFunction)**/
        map1.computeIfPresent("dpp", (key, value) -> value + 10);
        System.out.println(map1);
    }
}
