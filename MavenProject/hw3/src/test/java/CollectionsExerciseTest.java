import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionsExerciseTest {

    List<Integer> list = new ArrayList<>();

    @Before
    public void before(){
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(4);
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
        assertEquals(1, Collections.min(list).intValue());
        assertEquals(4, Collections.max(list).intValue());
        assertEquals(2, Collections.frequency(list, 4));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = Collections. synchronizedList(new ArrayList<>());
    }
}
