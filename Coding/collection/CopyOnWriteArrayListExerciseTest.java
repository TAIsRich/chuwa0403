package Coding.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertEquals;

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
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
        list.add(0);
        list.add(1);
        list.add(2); // 0 1 2
        list.add(1, 3); // 0 3 1 2
        list.addIfAbsent(2); // 0 3 1 2
        list.addIfAbsent(4); // 0 3 1 4

        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(1);
        anotherList.add(5);
        list.addAllAbsent(anotherList); // 0 3 1 4 5
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
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}
