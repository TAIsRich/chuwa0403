import org.junit.Test;

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
        // Create a new HashSet of integers
        Set<Integer> set = new HashSet<>();

        // Add some elements to the set
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        // Check if an element is in the set
        boolean containsTwo = set.contains(2); // returns true
        System.out.println(containsTwo);

        // Remove an element from the set
        boolean removedTwo = set.remove(2); // returns true
        System.out.println(set);

        // Clear the set
        set.clear(); // removes all elements from the set

        // Check if the set is empty
        boolean isEmpty = set.isEmpty(); // returns true
        System.out.println(isEmpty);
    }
}
