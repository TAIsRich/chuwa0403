package CollectionsTest;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionsExerciseTest {

    List<Integer> list1 = new ArrayList<>();

    @Before
    public void setUp() {
        list1.add(23);
        list1.add(12);
        list1.add(344);
        list1.add(224);
        list1.add(675);
    }

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
        System.out.println(Collections.min(list1));
        System.out.println(Collections.max(list1));
        System.out.println(Collections.frequency(list1, 23));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list2 = Collections.synchronizedList(list1);
        System.out.println(list2);
    }
}