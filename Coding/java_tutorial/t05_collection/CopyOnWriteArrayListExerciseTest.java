import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertTrue;

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
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Adding a single element
        list.add("Grapes");

        // Adding an element at a specific index
        list.add(2, "Pineapple");

        // Adding multiple elements
        List<String> moreFruits = Arrays.asList("Mango", "Papaya", "Kiwi");
        list.addAll(moreFruits);

        // Adding an element if it is not already present in the list
        ((CopyOnWriteArrayList<String>) list).addIfAbsent("Orange");

        // Adding multiple elements if they are not already present in the list
        List<String> uniqueFruits = Arrays.asList("Strawberry", "Raspberry", "Kiwi");
        ((CopyOnWriteArrayList<String>) list).addAllAbsent(uniqueFruits);

        // Retrieving an element by index
        String fruit = list.get(3);

        // Retrieving the first occurrence of an element
        int index = list.indexOf("Banana");

        // Retrieving the last occurrence of an element
        index = list.lastIndexOf("Kiwi");
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

        // Use the iterator to loop through the list
        for (String element : list) {
            System.out.println(element);
            list.remove(element);
        }

        // The list should now be empty
        assertTrue(list.isEmpty());
    }
}
