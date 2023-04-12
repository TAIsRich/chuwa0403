import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

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
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        list.add(0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);

        CopyOnWriteArrayList<Integer> listAdd1 = new CopyOnWriteArrayList<Integer>();
        listAdd1.add(4);
        listAdd1.add(5);

        list.addAll(listAdd1);

        System.out.println(list.toString()); //0 1 2 3 4 5

        list.addIfAbsent(6);

        CopyOnWriteArrayList<Integer> listAdd2 = new CopyOnWriteArrayList<Integer>();
        listAdd2.add(7);
        listAdd2.add(8);
        list.addAllAbsent(listAdd2);

        System.out.println(list.toString()); //0 1 2 3 4 5 6 7 8
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[]{1, 3, 5, 8});

        Iterator<Integer> iterator = numbers.iterator();
        int num = 0;
        while (iterator.hasNext()) {
            num = iterator.next();
        }

    }
}
