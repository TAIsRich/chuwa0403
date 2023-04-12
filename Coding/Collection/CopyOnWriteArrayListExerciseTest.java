package Coding.Collection;
import java.util.*;
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
    
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add(0, "Orange");
        CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        list.addAll(list2);
        list.addIfAbsent("Apple");
        list.addAllAbsent(list2);

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();
        itr.hasNext();
        itr.next();
        itr.remove();
    }
}