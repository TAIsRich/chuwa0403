
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();

        // Adding elements
        set.add(1);
        set.add(2);
        set.add(3);
        set.addAll(Arrays.asList(4, 5, 6));

        // Retrieving elements
        int size = set.size();
        boolean contains3 = set.contains(3);//have no get() method

        // Removing elements
        boolean removed = set.remove(1);
        boolean removedAll = set.removeAll(Arrays.asList(2, 3));
        set.clear();

        // Checking if set is empty
        boolean isEmpty = set.isEmpty();
    }
}
