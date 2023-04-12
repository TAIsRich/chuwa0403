
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
        Set<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        System.out.println("Original Set: " + set);

        // insert a collection of elements
        List<Integer> list = Arrays.asList(5, 4, 6);
        set.addAll(list);
        System.out.println("After adding collection: " + set);

        // check if an element exists in the set
        boolean contains = set.contains(4);
        System.out.println("Set contains 4: " + contains);

        // Retrieve the first and last element
        int first = ((TreeSet<Integer>) set).first();
        int last = ((TreeSet<Integer>) set).last();
        System.out.println("First element: " + first);
        System.out.println("Last element: " + last);

        // Retrieve a subset of elements
        Set<Integer> subset = ((TreeSet<Integer>) set).subSet(1, 3);
        System.out.println("Subset: " + subset);

        // Retrieve a head set of elements
        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(2);
        System.out.println("Head set: " + headSet);

        // Retrieve a tail set of elements
        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(2);
        System.out.println("Tail set: " + tailSet);

        // Check the size and emptiness of the set
        int size = set.size();
        boolean isEmpty = set.isEmpty();
        System.out.println("Size: " + size);
        System.out.println("Is empty: " + isEmpty);

        // remove an element from the set
        set.remove(2);
        System.out.println("After removing 2: " + set);

    }
}
