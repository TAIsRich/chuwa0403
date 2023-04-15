import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListExerciseTest {
    List<Integer> list = new ArrayList<>();

    @Before
    public void setup() {
        list.clear();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        list.add(3, 4);
        assertEquals(4, list.size());
        assertEquals(1, list.get(0).intValue());
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(5);
        anotherList.add(6);
        list.addAll(anotherList);
        assertEquals(6, list.size());
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
        list.remove(0);
        assertEquals(2, list.get(0).intValue());
        List<Integer> anotherList = new ArrayList<>();
        anotherList.add(5);
        anotherList.add(6);
        list.removeAll(anotherList);
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());

        list.add(1);
        list.set(0, 100);
        assertEquals(100, list.get(0).intValue());
        list.replaceAll((a) -> a + 1);
        assertEquals(101, list.get(0).intValue());

        assertTrue(list.contains(101));
        assertEquals(0, list.indexOf(101));
        assertEquals(0, list.lastIndexOf(101));
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
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            int val = iterator.next();
            iterator.remove();
        }
        assertTrue(list.isEmpty());
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        list.sort(Comparator.naturalOrder());
        assertEquals(1, list.get(0).intValue());
        Collections.sort(list);
        assertEquals(1, list.get(0).intValue());
        list.sort(Comparator.reverseOrder());
        assertEquals(3, list.get(0).intValue());
    }
}
