import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
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
        TreeSet<Integer> set= new TreeSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        Set<Integer> set1= new TreeSet<>();
        set1.add(6);
        set1.add(7);

        set.addAll(set1);

        boolean ifHasOne = set.contains(1);
        System.out.println(ifHasOne);

        System.out.println(set.first());
        System.out.println(set.last());

        Set<Integer> subSet = set.subSet(1, 3);
        Set<Integer> headSet = set.headSet(2);
        Set<Integer> tailSet = set.tailSet(2);

        System.out.println(subSet);
        System.out.println(headSet);
        System.out.println(tailSet);

        set.remove(3);

        System.out.println(set.size());

        boolean ifIsEmpty = set.isEmpty();
        System.out.println(ifIsEmpty);
    }
}