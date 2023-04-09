import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

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

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        set.addAll(l);

        assertTrue(set.contains(1));

        set.remove(1);
        assertFalse(set.contains(1));

        set.clear();
        assertTrue(set.isEmpty());
    }
}