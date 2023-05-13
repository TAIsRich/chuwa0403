package CollectionsTest;

import org.junit.Test;

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
     *
     * addAll(Collection c)
     *
     * addIfAbsent(E e)
     *
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        List<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("Watermelon");
        list2.add("Pineapple");
        list.addAll(list2);
        System.out.println(list);
        ((CopyOnWriteArrayList<String>) list).addIfAbsent("d");

        ((CopyOnWriteArrayList<String>) list).addIfAbsent("Apple");
        ((CopyOnWriteArrayList<String>) list).addAllAbsent(list2);
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

        //Iterating the elements of ArrayList object
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
