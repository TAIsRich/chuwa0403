import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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
        List<Integer> l = new ArrayList<>();
        l.add(-1);
        l.add(3);
        set.addAll(l);
        assertEquals(3, set.size());
        assertTrue(set.contains(-1));

        assertEquals(-1, set.first().intValue());
        assertEquals(3, set.last().intValue());

        assertEquals(2, set.subSet(-1, 1).size());
        assertEquals(0, set.headSet(-1).size());
        assertEquals(1, set.tailSet(3).size());

        set.remove(-1);
        assertEquals(2, set.size());
        assertFalse(set.isEmpty());
    }
}