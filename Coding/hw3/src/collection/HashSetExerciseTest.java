package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Min He
 * @date 4/9/23 10:13 AM
 */
public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        /** add(E e)**/
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(1);
        set2.add(4);
        set2.add(5);
        System.out.println(set1);
        System.out.println(set2);

        /** addAll(Collection<> c)**/
        set1.addAll(set2);
        System.out.println(set1);

        /** get()&contains()& remove(Object o)**/
        for(int num: set1){
            System.out.print(num + " ");
        }
        /** contains()& remove(Object o) & clear()**/
        List<Integer> list = new ArrayList<>(set2);
        for(int num : list){
            if(set1.contains(num)){
                set1.remove(num);
            }
        }
        set2.clear();
        System.out.println(set1);
        /** * isEmpty()**/
        boolean isEmpty = set2.isEmpty();
        System.out.println(isEmpty);
    }
}
