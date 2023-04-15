package com.chuwa.exercise.collection;

import org.junit.Test;

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
        // Create a list of strings
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Sort the list in natural order
        Collections.sort(names);
        System.out.println("Sorted names: " + names);

        // Shuffle the list
        Collections.shuffle(names);
        System.out.println("Shuffled names: " + names);

        // Reverse the list
        Collections.reverse(names);
        System.out.println("Reversed names: " + names);

        // Find the maximum and minimum elements in the list
        String max = Collections.max(names);
        String min = Collections.min(names);
        System.out.println("Max name: " + max);
        System.out.println("Min name: " + min);

        // Fill the list with a specific element
        Collections.fill(names, "John");
        System.out.println("Filled names: " + names);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
// Create a synchronized ArrayList
        List<String> names = Collections.synchronizedList(new ArrayList<>());

        // Add some names to the list
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Create a new thread to add more names to the list
        Thread t1 = new Thread(() -> {
            names.add("Dave");
            names.add("Emily");
        });

        // Create a new thread to remove a name from the list
        Thread t2 = new Thread(() -> {
            if (names.size() > 0) {
                names.remove(0);
            }
        });

        // Start the threads
        t1.start();
        t2.start();

        // Wait for the threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the contents of the list
        System.out.println("Names: " + names);
        //Names: [Bob, Charlie, Dave, Emily]
    }
}
