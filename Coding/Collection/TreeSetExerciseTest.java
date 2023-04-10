package Coding.Collection;
import java.util.*;

public class TreeSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        TreeSet<Integer> set1 = new TreeSet<>();
        set.add(3);
        set.add(4);
        set.addAll(set1);
        System.out.println(set.first());
        System.out.println(set.last());
        System.out.println(set.subSet(1, 0));
        System.out.println(set.headSet(1));
        System.out.println(set.tailSet(1));
        set.size();
        set.isEmpty();
    }
}
