package com.chuwa.learn;

import org.junit.Test;
import java.util.HashSet;
import java.util.Set;

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
       Set<Integer> set = new HashSet<>();
       set.add(1);
       set.add(2);
       Set<Integer> set1 = new HashSet<>();
       set1.add(3);
       set1.add(4);
       set.addAll(set1);
       System.out.println(set);

       System.out.println(set.contains(3));
       set.remove(4);
       System.out.println(set);
       set.clear();
       System.out.println(set.isEmpty());
    }
}
