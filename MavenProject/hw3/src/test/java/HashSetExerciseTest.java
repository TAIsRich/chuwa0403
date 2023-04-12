import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        Set<Integer> set= new HashSet<>();
        set.add(1);

        Set<Integer> setAdd = new HashSet<>();
        setAdd.add(2);
        set.addAll(setAdd);

        //set.get();
        assertEquals(false, set.contains(3));
        set.remove(1);
        set.clear();

        assertTrue(set.isEmpty());

    }
}
