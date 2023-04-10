package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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
    TreeSet<Integer> set;
    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        set = new TreeSet<>();
        set.add(0);
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(0);
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set.addAll(set2);

        assumeTrue(set.contains(1));
        assertEquals(0, set.first());
        assertEquals(5, set.last());

        Set<Integer> set3 = set.subSet(1, 3);
        Set<Integer> set4 = set.headSet(3);
        Set<Integer> set5 = set.tailSet(3);

        set.remove(5);
        assertEquals(5, set.size());
        assumeFalse(set.isEmpty());





    }
}
