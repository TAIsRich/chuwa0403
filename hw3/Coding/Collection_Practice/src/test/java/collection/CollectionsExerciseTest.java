package collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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

    List<Integer> list;
    @Test
    public void learn_common_collections_operations() {
        list = new ArrayList<>();
        list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 5, 5));

        assertEquals(0, Collections.min(list));
        assertEquals(5, Collections.max(list));
        assertEquals(3, Collections.frequency(list, 5));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        list = Collections.synchronizedList(Arrays.asList(0, 1, 2, 3));

        assertEquals(0, list.get(0));

    }
}
