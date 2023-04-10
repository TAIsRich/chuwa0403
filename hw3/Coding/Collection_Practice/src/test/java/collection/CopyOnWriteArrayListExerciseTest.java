package collection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author b1go
 * @date 6/12/22 4:46 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    CopyOnWriteArrayList<Integer> list;
    @Test
    public void learn_Inserting_And_Retrieving() {
        list = new CopyOnWriteArrayList<>();
        list.add(0);
        list.add(1, 1);
        list.addAll(Arrays.asList(2, 3, 4, 5));
        list.addIfAbsent(6);
        list.addAllAbsent(Arrays.asList(0, 7, 8));

        assertEquals(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), list);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Orange");

        //Created an iterator
        Iterator<String> itr = list2.iterator();
        while (itr.hasNext()) {
            String str = (String) itr.next();
            System.out.println(str);
            if (str.equals("Banana")) {
                assertThrows(UnsupportedOperationException.class,() -> itr.remove());
            }
        }
    }
}
