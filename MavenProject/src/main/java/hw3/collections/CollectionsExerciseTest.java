package hw3.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsExerciseTest {

    /**
     * Collections.min(list))
     * min(Collection c, Comparator comp)
     *
     * Collections.max(list)
     * max(Collection c, Comparator comp)
     *
     * frequency(Collection c, object o)
     */

    @Test
    public void learn_common_collections_operations() {
        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        List<Integer> list = Arrays.asList(numbers);

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> myList = Collections.synchronizedList(new ArrayList<>());

        myList.add(1);
        myList.add(3);
        myList.add(5);
        myList.add(1);

            for (Integer i : myList) {
                System.out.println(i);
            }
    }
}