package CollectionsTest;


import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetExerciseTest {
    TreeSet<Integer> set = new TreeSet<>();
    /**
     * e.g.
     * Set<Integer> set= new TreeSet<>();
     *
     * add(E e)
     * addAll(Collection<> c)
     *
     * contains(Object o)
     *
     * first()
     * last()
     * subSet(E fromElement, E toElement)
     * headSet(E toElement)
     * tailSet(E fromElement)
     *
     * remove(Object o)
     *
     * size()
     * isEmpty()
     *
     *
     */

    @Test
    public void learn_Inserting_And_Retrieving_Removing() {
        //add
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        
        //addAll
        TreeSet<Integer> set2 = new TreeSet<>();
        set2.add(4);
        set2.add(5);
        
        set.addAll(set2);
        System.out.println(set);
        
        //contains
        System.out.println(set.contains(1));
        System.out.println(set.contains(6));
        
        //first
        System.out.println(set.first());
        //last
        System.out.println(set.last());

        //subSet
        System.out.println(set.subSet(1, 3));

        //headSet
        System.out.println(set.headSet(3));

        //tailSet
        System.out.println(set.tailSet(3));

        //remove

        set.remove(1);
        System.out.println(set);

        //size
        System.out.println(set.size());

        //isEmpty
        System.out.println(set.isEmpty());
        
    }
}
