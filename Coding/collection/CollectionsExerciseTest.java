
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author b1go
 * @date 6/12/22 4:48 PM
 */
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
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 4, 6);

        // finding the minimum element
        int min = Collections.min(numbers);
        System.out.println("Minimum element: " + min);  // output: Minimum element: 2

        // finding the maximum element
        int max = Collections.max(numbers);
        System.out.println("Maximum element: " + max);  // output: Maximum element: 10

        // finding the frequency of an element
        int frequency = Collections.frequency(numbers, 4);
        System.out.println("Frequency of 4: " + frequency);  // output: Frequency of 4: 2
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");

        List<String> synchronizedList = Collections.synchronizedList(list);

        Runnable runnable = () -> {
            for (int i = 0; i < synchronizedList.size(); i++) {
                System.out.println(Thread.currentThread().getName() + ": " + synchronizedList.get(i));
            }
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
