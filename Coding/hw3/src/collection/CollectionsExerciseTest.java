package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author Min He
 * @date 4/9/23 21:25 PM
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
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));

        /** Collections.min(list))**/
        int small = Collections.min(list);
        System.out.println(small);

        /**min(Collection c, Comparator comp)*/
        List<String> words = new ArrayList<>(Arrays.asList("banana", "apple", "cherryLi", "apple"));
        Comparator<String> minComparator = new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length() - str2.length();
            }
        };
        String shortestWord = Collections.min(words, minComparator);
        System.out.println(shortestWord);

        /**Collections.max(list)**/
        int max = Collections.max(list);
        System.out.println(max);

        /**max(Collection c, Comparator comp)**/
        Comparator<String> maxComparator = (str1, str2) -> str2.length() - str1.length();
        String LongestWord = Collections.min(words, maxComparator);
        System.out.println(LongestWord);

        /**frequency(Collection c, object o)**/
        int fre = Collections.frequency(words,"apple");
        System.out.println(fre);
    }

    /**
     * synchronizedList()
     */

    @Test
    public void learn_thread_safe_ArrayList() {
        List<String> list = new ArrayList<>(Arrays.asList("Hao", "Bob", "Min"));

         /** synchronizedList()**/
        List<String> names = Collections.synchronizedList(list);
        System.out.println(names);
    }
}
