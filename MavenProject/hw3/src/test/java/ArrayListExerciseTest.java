import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListExerciseTest {
    ArrayList<Integer> list1 = new ArrayList<>();
    @Before
    public void before() {
        list1.clear();
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
        list1.add(10);
        list1.add(50);
        list1.add(100);
        assertEquals(10, list1.get(0).intValue());
        assertEquals(100, list1.get(2).intValue());
        assertEquals(3, list1.size());

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(5);
        list2.add(15);
        assertTrue(list1.addAll(list2));
        assertEquals(6, list1.size());
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
        list1.add(10);
        list1.add(50);
        list1.add(5);
        list1.add(15);
        list1.remove(0);
        Integer num = 50;
        list1.remove(num);
        //list1.removeRange(2, 3);
        List<Integer> listTest = new ArrayList<>();
        listTest.add(5);
        listTest.add(15);
        list1.removeAll(listTest);
        list1.clear();

        assertEquals(0, list1.size());

        list1.add(10);
        list1.add(50);
        list1.add(8);
        list1.add(8);

        list1.set(0, 8);
        Collections.replaceAll(list1,8,4);
        //4, 50, 4, 4
        System.out.println(list1.toString());
        assertTrue(list1.contains(4));
        assertEquals(-1, list1.indexOf(8));
        assertEquals(0, list1.indexOf(4));
        assertEquals(3, list1.lastIndexOf(4));
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
        /**
         * iterator()
         * hasNext()
         * next()
         * remove()
         * forEachRemaining(Consumer<? super E> action) -- from Java8
         */
        list1.add(10);
        list1.add(50);
        list1.add(100);
        list1.add(150);
        list1.add(200);

        Iterator<Integer> it = list1.iterator();

        Integer num = 0;
        while (it.hasNext()) {
            num = (Integer)it.next();
            if(num == 50){
                it.remove();
            }
        }

        Iterator<Integer> itTemp = list1.iterator();
        itTemp.forEachRemaining(System.out::println);
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        list1.add(50);
        list1.add(10);
        list1.add(5);

        list1.sort(Comparator.naturalOrder());
        assertEquals(0, list1.indexOf(5));

        list1.sort(Comparator.reverseOrder());
        assertEquals(0, list1.indexOf(50));

        Collections.sort(list1);
        assertEquals(0, list1.indexOf(5));

    }
}