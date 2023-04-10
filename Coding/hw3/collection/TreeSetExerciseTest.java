import org.junit.Test;

import java.util.Arrays;
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
        set.add(2);
        set.add(1);
        System.out.println("Set: " + set);

        set.addAll(Arrays.asList(4, 5, 6));
        System.out.println("New set: " + set);

        boolean containsTwo = set.contains(2);
        System.out.println("Set contains 2? " + containsTwo);

        Integer first = ((TreeSet<Integer>) set).first();
        System.out.println("First element: " + first);

        Integer last = ((TreeSet<Integer>) set).last();
        System.out.println("Last element: " + last);

        Set<Integer> subset = ((TreeSet<Integer>) set).subSet(1, 3);
        System.out.println("Subset: " + subset);

        Set<Integer> headSet = ((TreeSet<Integer>) set).headSet(2);
        System.out.println("Headset: " + headSet);

        Set<Integer> tailSet = ((TreeSet<Integer>) set).tailSet(2);
        System.out.println("Tailset: " + tailSet);

        boolean removedTwo = set.remove(2);
        System.out.println("Removed 2? " + removedTwo);
        System.out.println("Set after removal: " + set);

        int size = set.size();
        System.out.println("Size of set: " + size);

        boolean empty = set.isEmpty();
        System.out.println("Is set empty? " + empty);
    }
}
