import java.util.*;
public class hw_collection {
    public static void main(String[] args)
    {
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        l1.add(5);
        l1.add(8);
        l1.add(1);
        l1.add(0);
        l1.add(2);
        l1.remove(3);
        System.out.print(l1.get(1));
        System.out.println(l1.size());
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        l2.add(5);
        l2.add(8);
        l2.add(1);
        l2.add(0);
        l2.add(2);
        l1.addAll(l2);
        System.out.println(l1.size());
    }
}
