package com.chuwa.learn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExerciseTest {

    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    @Test
    public void learn_Inserting_And_Retrieving() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        System.out.println(list.size());
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list.addAll(list2);
        System.out.println(list);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     * <p>
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     * <p>
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        list.remove(new Integer(3));
        list.removeAll(list);
        list.clear();
        System.out.println(list);
        list.add(4);
        list.add(5);
        list.add(6);
        list.set(0,3);
        list.replaceAll(e -> e*2);
        System.out.println(list);
        System.out.println(list.contains(4));
        System.out.println(list.indexOf(4));
        list.add(4);
        System.out.println(list.lastIndexOf(4));
    }

    /**
     * iterator()
     * hasNext()
     * next()
     * remove()
     * forEachRemaining(Consumer<? super E> action) -- from Java8
     */

    @Test
    public void learn_Iterator() {

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {

    }
}

