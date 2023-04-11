package hw3.collections;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> another = Arrays.asList(1,2,3);
        tmp.add(0);
        int zero = tmp.get(0);
        tmp.addAll(another);
        int size = tmp.size();

        assertEquals(size, 4);
        assertEquals(zero, 0);


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
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(0);
        tmp.add(1);
        tmp.add(2);
        tmp.remove(0);
        int zero = tmp.get(0);
        assertEquals(1,zero);

        tmp.remove(1);
        boolean contain = tmp.contains(2);
        assertEquals(false, contain);

        tmp.set(0, 3);
        int firstelement = tmp.get(0);
        assertEquals(3, firstelement);
        tmp.add(2);
        tmp.add(3);
        tmp.add(4);
        tmp.add(5);
        tmp.removeAll(tmp);
        int size = tmp.size();
        assertEquals(0, size);

        tmp.add(0);
        size = tmp.size();
        assertEquals(1, size);
        tmp.clear();
        size = tmp.size();
        assertEquals(0, size);

        tmp.add(0);
        tmp.add(0);
        tmp.add(0);
        tmp.add(0);
        tmp.replaceAll(t -> t + 1);
        for (int i = 0; i < 4; i++) {
            int j = tmp.get(i);
            assertEquals(1, j);
        }

        int firstOne = tmp.indexOf(1);
        int lastOne = tmp.lastIndexOf(1);
        assertEquals(firstOne, 0);
        assertEquals(lastOne, 3);

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
        List<Integer> tmp = new ArrayList<>(Arrays.asList(0,1,2,3,4));
        Iterator it = tmp.iterator();
        for (it = tmp.iterator(); it.hasNext();) {
            Object cur = it.next();
            if (cur.equals(2)) {
                it.remove();
            }
            System.out.println(cur);
        }
        for (it = tmp.iterator(); it.hasNext();) {
            System.out.println(it.next()); // no 2
        }
        it = tmp.iterator();
        List<String> list1 = new ArrayList<>();
        it.forEachRemaining(ele -> System.out.println(ele));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> tmp = new ArrayList<>();
        tmp.add(7); tmp.add(1); tmp.add(5); tmp.add(3); tmp.add(4);
        Collections.sort(tmp);
        System.out.println(tmp);
        Collections.sort(tmp, Collections.reverseOrder());
        System.out.println(tmp);
    }
}
