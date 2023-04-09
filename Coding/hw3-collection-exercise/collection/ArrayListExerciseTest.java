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
        ArrayList<String> myList = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");
        myList.add("date");

        // Retrieving elements from the ArrayList
        String firstElement = myList.get(0);
        String thirdElement = myList.get(2);
        int size = myList.size();

        System.out.println("First element: " + firstElement); // Output: First element: apple
        System.out.println("Third element: " + thirdElement); // Output: Third element: cherry
        System.out.println("Size of the ArrayList: " + size); // Output: Size of the ArrayList: 4

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
        ArrayList<String> myList = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");
        myList.add("date");

        // Removing an element from the ArrayList
        myList.remove(1); // Removes the second element ("banana")

        // Replacing an element in the ArrayList
        myList.set(2, "orange"); // Replaces the third element ("cherry") with "orange"

        // Retrieving elements from the ArrayList
        String secondElement = myList.get(1);
        String thirdElement = myList.get(2);
        int size = myList.size();

        System.out.println("Second element: " + secondElement); // Output: Second element: cherry
        System.out.println("Third element: " + thirdElement); // Output: Third element: orange
        System.out.println("Size of the ArrayList: " + size); // Output: Size of the ArrayList: 3
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
        ArrayList<String> myList = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // Creating an iterator for the ArrayList
        Iterator<String> iterator = myList.iterator();

        // Iterating over the ArrayList using the iterator
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
        ArrayList<String> myList = new ArrayList<>();

        // Adding elements to the ArrayList
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

        // Sorting the ArrayList
        Collections.sort(myList);

        // Printing the sorted ArrayList
        for (String element : myList) {
            System.out.println(element);
        }
    }
}
