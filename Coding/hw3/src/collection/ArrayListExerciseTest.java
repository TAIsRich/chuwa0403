package com.chuwa.exercise.collection;

import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * @author Min He
 * @date 4/8/23 21:21PM
 */
public class ArrayListExerciseTest extends ArrayList<Integer> {
    /**
     * new ArrayList()
     * add elements
     * get element
     * get Size
     * list.addAll(anotherList)
     */
    ArrayList<Integer> list;
    public ArrayListExerciseTest(){
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }

    @Test
    public void learn_Inserting_And_Retrieving() {
        /**new ArrayList()**/
        List<Integer> list = new ArrayList<>();

        /** add elements**/
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        /** get element**/
        int element = list.get(0);
        System.out.println(element);

        /** get element**/
        int size = list.size();
        System.out.println(size);

        /**list.addAll(anotherList)**/
        List<Integer> copyList = new ArrayList<>();
        copyList.addAll(list);
        System.out.println(Arrays.toString(list.toArray()));
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

        List<Integer> list1 = new ArrayList<>(list);
        List<Integer> list2 = new ArrayList<>(list);
        System.out.println(list1);
        System.out.println(list2);

        /** remove(int index)**/
        list1.remove(0);
        System.out.println(list1);

        /** remove(Object o)**/
        list1.remove(Integer.valueOf(2));
        System.out.println(list1);

        /** removeRange(int fromIndex, int toIndex)
         * as removeRange is protected in ArrayList,So I made ArrayListExerciseTest as a subclass of ArrayList
         * and override the removeRange method
         */
        ArrayListExerciseTest test = new ArrayListExerciseTest();
        test.addAll(list1);
        test.removeRange(0,2);
        System.out.println(test);

        /** removeAll(Collection<?> c)**/
        list2.removeAll(test);
        System.out.println(list2);

        /** clear()**/
        list1.clear();
        System.out.println(list1);

        /**set(int index, E e)**/
        list2.set(0,0);
        System.out.println(list2);

        /** replaceAll(UnaryOperator<E> operator)*
         * https://howtodoinjava.com/java/collections/arraylist/arraylist-replaceall-example/
         * see myOperator class as below
         * */
        list2.replaceAll(new MyOperator());
        System.out.println(list2);

        /** contains(Object o)**/
        boolean contains1 = list2.contains(20);
        boolean contains2 = list2.contains(60);
        System.out.println(contains1);
        System.out.println(contains2);

        /** indexOf(Object o)**/
        int firstIndex = list2.indexOf(20);
        System.out.println(firstIndex);

        /** lastIndexOf(Object o)*/
        int lastIndex = list2.lastIndexOf(20);
        System.out.println(lastIndex);
    }
    @Override
    public void removeRange(int from,int to){
        super.removeRange(from,to);
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
        List<Integer> list1 = new ArrayList<>(list);
        System.out.println(list1);

        /** iterator()**/
        Iterator<Integer> iter = list1.iterator();

        /** hasNext() & next()&remove() **/
        while(iter.hasNext()){
            int num = iter.next();
            System.out.print(num + " ");
            if(num == 3){
                iter.remove();
            }
        }
        System.out.println(list1);

        /** forEachRemaining(Consumer<? super E> action) -- from Java8 **/
        Iterator<Integer> iter2 = list1.iterator();
        iter2.forEachRemaining(System.out::print);

    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(3);
        List<Integer> list2 = new ArrayList<>(list);
        List<Integer> list3 = new ArrayList<>(list);
        System.out.println(list);

        /** sort(List<T> list)
         * MyComparator as below
         * **/
       list.sort(new MyComparator());
       System.out.println("sort : " + list );

       /** Collections.sort(List<T> t)**/
       System.out.println(list2);
       Collections.sort(list2);
       System.out.println("Collections.sort : " + list2 );

       /** Comparator.reverseOrder() **/
        System.out.println(list3);
        list3.sort(Comparator.reverseOrder());
        System.out.println("Comparator.reverseOrder() : " + list3 );

    }

}


//replaceAll(UnaryOperator<E> operator)
class MyOperator implements UnaryOperator<Integer> {

    @Override
    public Integer apply(Integer integer) {
        return integer * 10;
    }
}
//sort(List<T> list)
class MyComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 == o2){
            return 0;
        }
        return o1 < o2?-1:1;
    }
}

