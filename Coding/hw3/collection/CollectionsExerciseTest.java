package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> num = Arrays.asList(2, 3, 1, 5, 10, 7);


        int min = Collections.min(num);

        int max = Collections.max(num);

        int frequency = Collections.frequency(num, 4);

    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        l.add(3);

        List<Integer> synchronizedList = Collections.synchronizedList(l);

        Runnable runnable = () -> {
            for (int i = 0; i < synchronizedList.size(); i++) {
                System.out.println(Thread.currentThread().getName() + ": " + synchronizedList.get(i));
            }
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");

        thread1.start();
        thread2.start();
    }
}
