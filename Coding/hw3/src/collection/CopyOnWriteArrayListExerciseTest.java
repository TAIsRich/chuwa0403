package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Min He
 * @date 4/9/22 2:13 PM
 */
public class CopyOnWriteArrayListExerciseTest {

    /**
     * e.g.
     * List list = new CopyOnWriteArrayList();
     *
     * add(E e)
     * add(int index, E element)
     * addAll(Collection c)
     * addIfAbsent(E e)
     * addAllAbsent(Collection c)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        /** add(E e)**/
        list.add(-1);
        list.add(8);
        list.add(0);
        list.add(4);
        System.out.println(list);

        /** add(int index, E element)**/
        list.add(1,0);
        System.out.println(list);

        /** addAll(Collection c)**/
        CopyOnWriteArrayList<Integer> list2 = new CopyOnWriteArrayList<>();
        list2.add(-2);
        list2.addAll(list);
        System.out.println(list2);

        /**addIfAbsent(E e)**/
        list2.addIfAbsent(3);
        list2.addIfAbsent(-3);
        System.out.println(list2);

        /** addAllAbsent(Collection c)**/

        list.addAllAbsent(list2);
        System.out.println(list);

    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     */

    @Test
    public void learn_Iterator() {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        //Created an iterator
        Iterator<String> itr = list.iterator();

        /** hasNext() & next()&remove() **/
        while(itr.hasNext()){
            String ele = itr.next();
           System.out.print(ele + " ");
           if(ele.equals("Banana")){
               list.remove(ele);
           }

        }
        System.out.println(list);
    }
}
