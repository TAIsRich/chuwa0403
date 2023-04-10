package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Min He
 * @date 4/9/23 20:23 PM
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

        /** put(K key, V value)**/
        map.put("one",1);
        map.put("two",2);
        map.put("three",1);
        System.out.println(map);

        /**putIfAbsent(K key, V value)**/
        map.putIfAbsent("four",3);
        map.putIfAbsent("five",1);
        System.out.println(map);

        /**putAll(Map<? extends K, ? extends V> m)**/
        Map<String, Integer> map1 = new HashMap<>();
        map1.putAll(map);
        System.out.println(map1);

        /**get(Object key)**/
        int val = map.get("one");
        System.out.println(val);

        /**getOrDefault(Object key, V defaultValue)**/
        int value1 = map.getOrDefault("one",0);
        int value2 = map.getOrDefault("six",0);
        System.out.println(value1);
        System.out.println(value2);

        /**containsKey(Object key) & containsValue(Object value)**/
        System.out.println(map.containsKey("two"));
        System.out.println(map.containsValue(7));

        /**keySet()**/
        for(String key : map.keySet()){
            System.out.print(key + " ");
        }

        /**values()**/
        for(int num : map.values()){
            System.out.print(num + " ");
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
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("one",1);
        map1.put("two",2);
        map1.put("three",1);
        System.out.println(map1);

        /**replace(K key, V oldValue, V newValue)**/
        boolean repalce = map1.replace("one",1,3);
        System.out.println(repalce);
        System.out.println(map1);

        /**replace(K key, V value)**/
        Integer oldValue = map1.replace("three",4);
        System.out.println(oldValue);
        System.out.println(map1);

        /**replaceAll(BiFunction<? super K, ? super V, ? extends V> function)**/
        map1.replaceAll((key,value)->value + 10);
        System.out.println(map1);

        /**remove(Object key) &&remove(Object key, Object value) **/
        System.out.println(map1.remove("one"));
        System.out.println(map1.remove("two",2));
        System.out.println(map1.remove("two",12));
        System.out.println(map1);

        /**compute(Key, BiFunction)**/
        map1.compute("three", (key, value) -> value + 10);
        System.out.println(map1);

        /** computeIfAbsent(Key, Function)**/
        map1.computeIfAbsent("one",key-> map1.size());
        System.out.println(map1);

        /**computeIfPresent(Key, BiFunction)**/
        map1.computeIfPresent("one", (key, value) -> value + 10);
        System.out.println(map1);

    }
}
