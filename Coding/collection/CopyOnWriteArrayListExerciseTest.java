
import org.junit.Test;

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
    @Test
    public void learn_Inserting_And_Retrieving() {
        // Create a CopyOnWriteArrayList
        List<Integer> list = new CopyOnWriteArrayList<>();

        // Adding elements
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("List after adding elements: " + list);

        // Adding element at specific index
        list.add(2, 5);
        System.out.println("List after adding element at index 2: " + list);

        // Adding collection of elements
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(6);
        anotherList.add(7);
        list.addAll(anotherList);
        System.out.println("List after adding collection of elements: " + list);

        // Adding element if absent
        ((CopyOnWriteArrayList<Integer>) list).addIfAbsent(4);
        ((CopyOnWriteArrayList<Integer>) list).addIfAbsent(8);
        System.out.println("List after adding element if absent: " + list);

        // Adding collection of elements if absent
        List<Integer> yetAnotherList = new ArrayList<>();
        yetAnotherList.add(9);
        yetAnotherList.add(10);
        ((CopyOnWriteArrayList<Integer>) list).addAllAbsent(yetAnotherList);
        System.out.println("List after adding collection of elements if absent: " + list);
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

        //Using hasNext() and next() methods
        while (itr.hasNext()) {
            String fruit = itr.next();
            System.out.println(fruit);
        }

        //Using remove() method
        itr = list.iterator();
        while (itr.hasNext()) {
            String fruit = itr.next();
            if (fruit.equals("Banana")) {
                itr.remove();//unsupported
            }
        }

        //Using forEachRemaining() method
        itr = list.iterator();
        itr.forEachRemaining(fruit -> {
            System.out.println(fruit);
        });
    }
}
