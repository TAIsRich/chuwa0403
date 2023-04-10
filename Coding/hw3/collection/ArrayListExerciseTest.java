package com.chuwa.exercise.collection;

import org.junit.Test;

import java.awt.*;
import java.util.*;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
public class ArrayListExerciseTest extends ArrayList<Integer>{
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */

    @Test
    public void learn_Inserting_And_Retrieving() {
        ArrayList<Integer> l =  new ArrayList<>();
        l.add(0);
        l.add(1);
        l.get(0);
        l.size();
        ArrayList<Integer> l2 = new ArrayList<>();
        l.addAll(l2);
    }

    /**
     * remove(int index)
     * remove(Object o)
     * removeRange(int fromIndex, int toIndex)
     * removeAll(Collection<?> c)
     * clear()
     *
     * Update:
     * set(int index, E e)
     * replaceAll(UnaryOperator<E> operator)
     *
     * check:
     * contains(Object o)
     * indexOf(Object o)
     * lastIndexOf(Object o)
     */
    @Test
    public void learn_Remove_Replacing_Updating() {
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);
        if (l.size() != 0){
            l.remove(0);
        }

        int obj = 1;
        if(l.contains(obj)){
            l.remove(obj);
        }

        l.removeAll(l);
//        super.removeRange(0, 0);

        l.clear();
        l.add(0);
        l.set(0, 1);
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
        alphabets.replaceAll( e -> e.toLowerCase() );
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
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        Iterator<String> it = cars.iterator();
        it.hasNext();
        it.next();
        it.remove();

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();

        iterator.forEachRemaining((fruit) -> System.out.println(fruit));

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<Integer> newl = new ArrayList<>();
        newl.add(2);
        newl.add(3);
        Collections.sort(newl);
        newl.sort(Comparator.reverseOrder());
    }
}
