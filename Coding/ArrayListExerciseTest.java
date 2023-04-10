package com.chuwa.exercise.collection;

import org.junit.Test;

/**
 * @author b1go
 * @date 6/12/22 4:43 PM
 */
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
        // create an ArrayList
        ArrayList<String> list = new ArrayList<String>();

        // add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // retrieve elements from the ArrayList
        String firstElement = list.get(0);
        String secondElement = list.get(1);

        System.out.println("First Element: " + firstElement);
        System.out.println("Second Element: " + secondElement);

        // insert an element into the ArrayList
        list.add(2, "Elderberry");

        // retrieve the updated element from the ArrayList
        String thirdElement = list.get(2);

        System.out.println("Third Element: " + thirdElement);

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
        // create an ArrayList
        ArrayList<String> list = new ArrayList<String>();

        // add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // remove an element from the ArrayList
        list.remove(2);

        // replace an element in the ArrayList
        list.set(1, "Grape");

        // update an element in the ArrayList
        String updatedElement = list.get(0) + " Pie";
        list.set(0, updatedElement);

        // iterate over the ArrayList and print its elements
        for (String element : list) {
            System.out.println(element);
        }
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
        // create an ArrayList
        ArrayList<String> list = new ArrayList<String>();

        // add elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // create an Iterator to iterate over the ArrayList
        Iterator<String> iterator = list.iterator();

        // iterate over the ArrayList using the Iterator
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        // create an ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();

        // add elements to the ArrayList
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);

        // sort the ArrayList using the Collections class
        Collections.sort(list);

        // iterate over the ArrayList and print its elements
        for (Integer element : list) {
            System.out.println(element);
        }

    }
}
