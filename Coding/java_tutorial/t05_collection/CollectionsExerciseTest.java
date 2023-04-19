import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        // create a list of integers
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 4, 2, 8, 5, 7, 3, 6));

        // get the minimum and maximum values in the list
        int min = Collections.min(numbers);
        int max = Collections.max(numbers);

        // check that the results are correct
        assertEquals(1, min);
        assertEquals(8, max);

        // create a list of strings
        ArrayList<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "orange", "banana", "apple"));

        // get the frequency of the word "banana"
        int frequency = Collections.frequency(words, "banana");

        // check that the result is correct
        assertEquals(2, frequency);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> synchronizedList = Collections.synchronizedList(list);
    }
}
