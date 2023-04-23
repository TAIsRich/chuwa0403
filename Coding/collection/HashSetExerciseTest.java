import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetExerciseTest {
    /**
     * e.g.
     * Set<Integer> set= new HashSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * get()
     * contains()
     *
     * remove(Object o)
     * clear()
     *
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        set.add(1);
        set.add(2);

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        set.addAll(list);

        System.out.println(set.contains(1));

        set.remove((Integer)0);
        System.out.println(set.contains(0));

        set.clear();
        System.out.println(set.isEmpty());


    }
}
