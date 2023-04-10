package Coding.Collection;
import java.util.*;

public class ArrayListExerciseTest {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    //@Test
    List<Integer> test = new ArrayList<>();
    public void learn_Inserting_And_Retrieving() {
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.get(0);
        test.size();
        List<Integer> test2 = new ArrayList<>();
        test2.add(1);
        test2.add(0);
        test.addAll(test2);

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
    //@Test
    public void learn_Remove_Replacing_Updating() {
        test.remove(0);
        test.removeAll(test);
        test.clear();

        test.set(0, 1);
        test.replaceAll(e -> e + 2);

        test.contains(1);
        test.indexOf(1);
        test.lastIndexOf(1);
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    //@Test
    public void learn_Iterator() {
        Iterator<Integer> it = test.iterator();
        it.next();
        it.hasNext();
        it.remove();
        it.forEachRemaining((number) -> System.out.println(number));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    //@Test
    public void learn_Sorting() {
        Collections.sort(test);
    }
}
