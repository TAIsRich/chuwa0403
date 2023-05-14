package hw3.collections;

import org.junit.Test;

import java.util.Arrays;
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
        CopyOnWriteArrayList<Integer> tmp = new CopyOnWriteArrayList<>();
        tmp.add(0);
        tmp.add(1,1);
        tmp.addAll(2, Arrays.asList(2,3,4));
        System.out.println(tmp);
        tmp.addIfAbsent(3);
        System.out.println(tmp);
        tmp.addAllAbsent(Arrays.asList(1,2,3,4,5));
        System.out.println(tmp);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        //Created an iterator
        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj);
        }
    }
}