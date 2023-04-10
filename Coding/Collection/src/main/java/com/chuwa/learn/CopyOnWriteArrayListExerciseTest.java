package com.chuwa.learn;

import java.util.*;
import org.junit.Test;
import java.util.concurrent.CopyOnWriteArrayList;
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
       CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(0,4);
       System.out.println(list);
       List list1 = new CopyOnWriteArrayList();
       list1.add(5);
       list1.add(6);
       list.addAll(list1);
       list.addIfAbsent(7);
       System.out.println(list);

       list1.add(8);
       list1.add(9);
       list.addAllAbsent(list1);
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

        while(itr.hasNext()){
            System.out.println(itr.next()+" ");
        }

        while (itr.hasNext()){
            String s = itr.next();
            if (s.equalsIgnoreCase("Strawberry")){
                list.remove(s);
            }
        }
    }
}
