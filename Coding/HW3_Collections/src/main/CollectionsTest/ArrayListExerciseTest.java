package CollectionsTest;


import org.junit.Test;
import java.util.*;

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1,12);
        System.out.println(list.get(0));
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.addAll(list2);
        System.out.println(list);

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
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // remove

        list.remove(1);
        System.out.println(list);
        list.remove(Integer.valueOf(3));
        System.out.println(list);
        list.removeAll(Arrays.asList(4));
        System.out.println(list);
        list.clear();


        // update
        list.add(10);
        list.set(0, 5);

        list.add(11);
        list.add(15);
        System.out.println(list);
        list.set(2, 12);
        System.out.println(list);
        list.replaceAll(x -> x * 2);
        System.out.println(list);

        // check
        System.out.println(list.contains(10));
        System.out.println(list.indexOf(12));
        System.out.println(list.lastIndexOf(22));
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
List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // from Java8
        list.forEach(System.out::println);

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(222);
        list.add(13);
        list.add(41);

        Collections.sort(list);
        System.out.println(list);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
