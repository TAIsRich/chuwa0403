import org.junit.Test;

import java.util.*;

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
        ArrayList<String> list = new ArrayList<>();
        // add elememts
        list.add("Tom");
        list.add("Amy");
        list.add("Cam");
        list.add("Phil");
        list.add("Luke");

        // get elememt
        String element = list.get(3);
        System.out.println(element);

        // get size
        int size = list.size();
        System.out.println(size);

        // list.addAll(anotherList)
        List<String> anotherList = new ArrayList<>();
        anotherList.add("Jay");
        anotherList.add("Hayley");
        list.addAll(anotherList);
        System.out.println(list);
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
        ArrayList<String> list = new ArrayList<>();
        list.add("Tom");
        list.add("Amy");
        list.add("Cam");
        list.add("Phil");
        list.add("Luke");
        list.add("Jay");
        list.add("Hayley");
        list.add("yuanchen");
        list.add("Alex");
        list.add("Manny");


        // remove(int index)
        list.remove(1);

        // remove(Object o)
        list.remove("Cam");

        // removeRange(int fromIndex, int toIndex). No removeRange method in my Java.
        list.subList(0, 1).clear();

        // removeAll(Collection<?> c)
        ArrayList<String> anotherList = new ArrayList<>();
        anotherList.add("Alex");
        anotherList.add("Manny");
        list.removeAll(anotherList);
        System.out.println(list);

        // clear()
        list.clear();

        // add elements
        list.add("Tom");
        list.add("Amy");
        list.add("Cam");
        list.add("Phil");
        list.add("Luke");
        list.add("Jay");
        list.add("Hayley");
        list.add("yuanchen");
        list.add("Alex");
        list.add("Manny");

        // set(int index, E e)
        list.set(3, "menmen");

        // replaceAll(UnaryOperator<E> operator)
        list.replaceAll(s -> s.toUpperCase());

        // contains(Object o)
        boolean ifHasJAY = list.contains("JAY");
        System.out.println(ifHasJAY);

        // indexOf(Object o)
        int index = list.indexOf("JAY");
        System.out.println(index);

        // lastIndexOf(Object o)
        int lastIndex = list.lastIndexOf("JAY");
        System.out.println(lastIndex);

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
        ArrayList<String> list = new ArrayList<String>();
        list.add("Tom");
        list.add("Amy");
        list.add("Cam");
        list.add("Phil");
        list.add("Luke");
        list.add("Jay");
        list.add("Hayley");
        list.add("yuanchen");
        list.add("Alex");
        list.add("Manny");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String element = iterator.next();
            iterator.remove();
        }
        list.forEach(fruit -> System.out.println(fruit));
    }

    /**
     * sort(List<T> list)
     * Collections.sort(List<T> t)
     * Comparator.reverseOrder()
     */

    @Test
    public void learn_Sorting() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Tom");
        list.add("Amy");
        list.add("Cam");
        list.add("Phil");
        list.add("Luke");
        list.add("Jay");
        list.add("Hayley");
        list.add("yuanchen");
        list.add("Alex");
        list.add("Manny");

        Collections.sort(list);
        Collections.sort(list, Comparator.reverseOrder());

    }
}