import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     * <p>
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("b");
        list.add(0, "a");
        List<String> l2 = new ArrayList<>();
        l2.add("c");
        l2.add("d");
        list.addAll(l2);
        assertEquals("a", list.get(0));
        assertEquals(4, list.size());

        list.addIfAbsent("d");
        assertEquals(4, list.size());

        list.addAllAbsent(l2);
        assertEquals(4, list.size());
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            String val = itr.next();
        }
        list.clear();
        assertTrue(list.isEmpty());
    }
}