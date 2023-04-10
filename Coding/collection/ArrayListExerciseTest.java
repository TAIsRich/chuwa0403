package Coding.collection;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    List<Integer> list;
    @Test
    public void learn_Inserting_And_Retrieving() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        assertEquals((Integer)2, list.get(1));

        List<Integer> anotherList = Arrays.asList(3, 4, 5);
        list.addAll(anotherList);
        assertEquals(5, list.size());
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        list.remove(0); // 1 2 3 4
        assertEquals((Integer)1, list.get(0));

        list.remove((Integer) 4); // 1 2 3
        assertEquals(3, list.size());

        list.removeAll(list);
        assertEquals(0, list.size());

        list.add(6); // 6
        list.clear();
        assertEquals(0, list.size());

        list.add(0); // 0
        list.set(0, 1); // 1
        assertEquals((Integer)1, list.get(0));

        list.add(2); // 1 2
        list.replaceAll(e -> e * 10); // 10 20
        assertEquals((Integer)20, list.get(1));

        assertTrue(list.contains((Integer)20));
        assertEquals(0, list.indexOf(10));

        list.add(10); // 10 20 10
        assertEquals(2, list.lastIndexOf(10));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {
        list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals((Integer)0, it.next());

        it.remove(); // 1 2 3 4
        assertEquals((Integer)1, list.get(0));

        it.forEachRemaining(i -> System.out.println(i));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        list = new ArrayList<>();
        list.add(3);
        list.add(0);
        list.add(4);
        list.add(1);
        list.add(2); // 3 0 4 1 2

        list.sort(Comparator.comparingInt(o -> o)); // 0 1 2 3 4
        assertEquals((Integer)0, list.get(0));

        list.set(0, 5); // 5 1 2 3 4
        Collections.sort(list); // 1 2 3 4 5
        assertEquals((Integer)1, list.get(0));

        Collections.sort(list, Comparator.reverseOrder()); // 5 4 3 2 1
        assertEquals((Integer)5, list.get(0));
    }
}
