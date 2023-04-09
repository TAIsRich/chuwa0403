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

        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        System.out.println(set);

        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3));
        set.addAll(set2);
        System.out.println(set);

        // No get method in Set

        System.out.println(set.contains(1));

        set.remove(1);
        System.out.println(set.contains(1));

        set.clear();
        System.out.println(set.isEmpty());

    }
}
