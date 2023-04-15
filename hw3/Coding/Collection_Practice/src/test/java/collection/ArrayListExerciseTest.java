package collection;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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
        List<Integer> anotherList = Arrays.asList(2, 3, 4);
        list.add(0);
        list.add(1);
        list.addAll(anotherList);

        assertEquals(2, list.get(2));
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
        list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));

        list.remove(0);
        assertEquals(1, list.get(0));

        list.removeAll(Arrays.asList(3, 4, 5));
        assertEquals(list, Arrays.asList(1, 2));

        list.clear();
        assumeTrue(list.isEmpty());

        list.add(10);
        list.set(0, 0);
        assertEquals(0, list.get(0));

        list = Arrays.asList(1, 1, 1, 1, 1);
        list.replaceAll(e -> 0);
        assertEquals(list, Arrays.asList(0, 0, 0, 0, 0));

        assumeTrue(list.contains(0));
        assertEquals(0, list.indexOf(0));
        assertEquals(4, list.lastIndexOf(0));


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
        list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));

        Iterator<Integer> iterator = list.iterator();
        assumeTrue(iterator.hasNext());

        assertEquals(0, iterator.next());
        iterator.remove();
        assertEquals(5, list.size());

        iterator.forEachRemaining(System.out::println);

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        list = new ArrayList<>();
        list.addAll(Arrays.asList(5, 4, 3, 2, 1, 0));
        Collections.sort(list);
        assertEquals(0, list.get(0));

        list.sort(Comparator.reverseOrder());
        assertEquals(5, list.get(0));
    }
}
