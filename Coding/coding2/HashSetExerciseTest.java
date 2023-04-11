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
        HashSet<Integer> set= new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);

        Set<Integer> set1= new HashSet<>();

        set1.add(4);
        set1.add(5);

        set.addAll(set1);

        boolean ifHasOne = set.contains(1);
        System.out.println(ifHasOne);

        set.remove(2);
        set.clear();
        boolean ifEmpty = set.isEmpty();
        System.out.println(ifEmpty);





    }
}
