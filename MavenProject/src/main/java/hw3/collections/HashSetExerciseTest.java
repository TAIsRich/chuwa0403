package hw3.collections;

import org.junit.Test;

import java.util.*;

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
        HashSet<Integer> set= new HashSet<>();
        set.add(0);
        set.addAll(Arrays.asList(0,1,2));
        System.out.println(set);

        System.out.println(set.contains(0));
        set.remove(0);
        System.out.println(set);

        set.clear();
        System.out.println(set);

        System.out.println(set.isEmpty());

    }
}
