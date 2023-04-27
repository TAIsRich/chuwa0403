package hw3.collections;
import org.junit.Test;

import java.util.TreeSet;


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

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(79);
        set.add(78);
        set.add(3);
        System.out.println(set.first());
        System.out.println(set.last());

        System.out.println(set.subSet(2,6));
        System.out.println(set.headSet(2));
        System.out.println(set.tailSet(2));

        set.remove(3);
        System.out.println(set.size());
        System.out.println(set.isEmpty());
    }
}
