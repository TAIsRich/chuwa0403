package Coding.Collection;

import java.util.*;

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

    List<Integer> list = new ArrayList<>();
    public void learn_common_collections_operations() {
        
        list.add(1);
        list.add(2);
        list.add(3);
 
        int min = Collections.min(list);
        int frequency = Collections.frequency(list, 1);
        System.out.println(min);
        System.out.println(frequency);
        System.out.println(list);
    }

    /**
     * synchronizedList()
     */

    
    public void learn_thread_safe_ArrayList() {
        List<Integer> list1 = Collections.synchronizedList(list);
        System.out.println(list1);
    }
}