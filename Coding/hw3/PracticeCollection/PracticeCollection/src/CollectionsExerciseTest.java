import org.junit.Test;

import java.util.ArrayList;
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

        ArrayList<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(2);
            add(2);
        }};

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));

        System.out.println(Collections.min(list, (x, y) -> y - x));
        System.out.println(Collections.max(list, (x, y) -> y - x));

        System.out.println(Collections.frequency(list, 2));
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {

        ArrayList<Integer> list = new ArrayList<>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(2);
            add(2);
        }};

        List<Integer> synlist = Collections.synchronizedList(list);
        System.out.println(synlist);

    }
}
