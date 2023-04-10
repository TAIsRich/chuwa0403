package Coding.collection;

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
        List<Character> letters = new ArrayList<>();
        letters.add('a');
        letters.add('b');
        letters.add('c');
        letters.add('b');
        letters.add('d');
        System.out.println(Collections.min(letters));
        System.out.println(Collections.max(letters));
        System.out.println(Collections.frequency(letters, 'b'));

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Character> letters = Collections.synchronizedList(new ArrayList<>());
        letters.add('a');
        letters.add('b');
        letters.add('c');

        Thread t1 = new Thread(() -> {
            letters.add('d');
            System.out.println(letters);
        });

        Thread t2 = new Thread(() -> {
            letters.remove(letters.size() - 1);
            letters.add('e');
            System.out.println(letters);
        });

        t1.start();
        t2.start();
    }
}
