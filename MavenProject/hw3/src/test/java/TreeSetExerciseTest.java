import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

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
         set.add(1);
         set.add(2);
         set.add(3);
         Set<Integer> setAdd = new TreeSet<>();
         setAdd.add(4);
         set.addAll(setAdd);
         set.contains(0);

         //0 1 2 3 4
        assertEquals(0, set.first().intValue());
        assertEquals(4, set.last().intValue());

        Set<Integer> setSub = set.subSet(0,2);
        Set<Integer> setHead = set.headSet(1);
        Set<Integer> setTail = set.tailSet(1);

        set.remove(0);

        assertEquals(4, set.size());
        assertEquals(false, set.isEmpty());
    }
}
