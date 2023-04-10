package collection;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
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
    Set<Integer> set;

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        set = new HashSet<>();
        set.add(1);
        Set<Integer> set2 = new HashSet<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        set.addAll(set2);

        assumeTrue(set.contains(1));

        set.remove(1);
        assertEquals(2, set.size());

        set.clear();
        assumeTrue(set.isEmpty());

    }
}
