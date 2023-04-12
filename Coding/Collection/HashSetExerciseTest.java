package Coding.Collection;
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

    
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set= new HashSet<>();
        set.add(1);
        Set<Integer> set2= new HashSet<>();
        set.add(2);
        set.addAll(set2);

        set.contains(1);
        set.remove(1);
        set.clear();
        set.isEmpty();
    }
}
