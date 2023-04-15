import org.junit.Test;

import java.util.*;

import static java.util.Collections.reverseOrder;

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
    @Test
    public void learn_Inserting_And_Retrieving() {

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < 5; i++) a.add(i);
        for (int i = 6; i < 10; i++) b.add(i);

        System.out.println(a.get(0));
        System.out.println(a.size());

        a.addAll(b);
        System.out.println(a);

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

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> copy = new ArrayList<>(a);
        for (int i = 0; i < 10; i++) a.add(i);

        System.out.println(a);

        // remove(int index); remove(Object o)
        a.remove(9);
        System.out.println(a);

        // remove(int value)
        a.remove(Integer.valueOf(2));
        System.out.println(a);

        // removeRange(int fromIndex, int toIndex); clear()
        a.subList(6, a.size()).clear();
        System.out.println(a);

        // removeAll(Collection<?> c)
        ArrayList<Integer> b = new ArrayList<>() {{
            add(1);
            add(3);
            // This element doesn't exist, will skip
            add(6);
        }};
        a.removeAll(b);
        System.out.println(a);

        // set(int index, E e)
        a.set(0, 100);
        System.out.println(a);

        // replaceAll(UnaryOperator<E> operator)
        a.replaceAll(x -> x + 1);
        System.out.println(a);

        // contains(Object o)
        System.out.println(a.contains(100));
        System.out.println(a.contains(101));

        a.add(101);
        System.out.println(a);

        // indexOf(Object o)
        System.out.println(a.indexOf(101));

        // lastIndexOf(Object o)
        System.out.println(a.lastIndexOf(101));


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

        List<String> myList = new ArrayList<>();
        myList.add("apple");
        myList.add("banana");
        myList.add("orange");

        ListIterator<String> iterator = myList.listIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            if (element.equals("banana")) {
                iterator.add("pear");
            } else if (element.equals("orange")) {
                iterator.set("grapefruit");
            } else if (element.equals("apple")) {
                iterator.remove();
            }
        }
        System.out.println(myList);

        ListIterator<String> iterator_1 = myList.listIterator();
        // skip banana
        iterator_1.next();
        iterator_1.forEachRemaining(f -> {
            System.out.println("This fruit is: " + f);
        });

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 1, 5, 3));
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Comparator.reverseOrder());
        System.out.println(list);
    }
}
