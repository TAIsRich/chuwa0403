
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;

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
        // create a new ArrayList
        List<String> list = new ArrayList<>();

        // add some elements
        list.add("hello");
        list.add("world");
        list.add("!");

        // retrieve an element
        String firstElement = list.get(0);
        System.out.println(firstElement); // prints "hello"

        // get the size
        int size = list.size();
        System.out.println(size); // prints 3

        // add all elements from another list
        List<String> anotherList = Arrays.asList("foo", "bar", "baz");
        list.addAll(anotherList);

        // print all elements
        for (String element : list) {
            System.out.println(element);
        }
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
        // create a new ArrayList
        List<String> list = new ArrayList<>();

        // add some elements
        list.add("hello");
        list.add("world");
        list.add("!");

        // remove an element
        list.remove(0);

        // remove a specific element
        list.remove("world");

        // remove a range of elements
        //list.removeRange(0, 1);

        // remove all elements in a collection
        list.removeAll(Arrays.asList("foo", "bar"));

        // clear the list
        list.clear();

        // add some elements back
        list.add("hello");
        list.add("world");
        list.add("!");

        // replace an element
        list.set(0, "hi");

        // replace all elements
        list.replaceAll(s -> s.toUpperCase());

        // check if an element is present
        boolean containsHello = list.contains("hello");

        // get the index of an element
        int index = list.indexOf("world");

        // get the last index of an element
        int lastIndex = list.lastIndexOf("!");

        // print all elements
        for (String element : list) {
            System.out.println(element);
        }
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
        class MyList<T> implements Iterable<T> {

            private T[] elements;
            private int size;

            // constructor and other methods not shown for brevity

            @Override
            public Iterator<T> iterator() {
                return new MyIterator();
            }

            class MyIterator implements Iterator<T> {
                private int cursor;

                public MyIterator() {
                    cursor = 0;
                }

                @Override
                public boolean hasNext() {
                    return cursor < size;
                }

                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return elements[cursor++];
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void forEachRemaining(Consumer<? super T> action) {
                    while (hasNext()) {
                        action.accept(next());
                    }
                }
            }
        }
    }



    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> numbers = Arrays.asList(4, 2, 1, 5, 3);

        // Sorting the list in ascending order
        Collections.sort(numbers);
        System.out.println("Ascending order: " + numbers);

        // Sorting the list in descending order
        Collections.sort(numbers, Comparator.reverseOrder());
        System.out.println("Descending order: " + numbers);
    }
}
