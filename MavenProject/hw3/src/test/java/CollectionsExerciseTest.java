import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;

public class CollectionsExerciseTest {
    List<Integer> l = new ArrayList<>();

    @Before
    public void before() {
        l.add(1);
        l.add(2);
        l.add(3);
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
        assertEquals(1, Collections.min(l).intValue());
        assertEquals(3, Collections.max(l).intValue());
        assertEquals(1, Collections.frequency(l, 1));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
    }
}