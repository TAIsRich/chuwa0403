import java.util.*;

public class Average {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(20, 3, 78, 9, 6, 53, 73, 99, 24, 32));
        System.out.println(
                (double) (list.stream().reduce((a1, a2) -> a1 + a2).orElseThrow(() -> new NullPointerException())
                        / list.size()));
    }
}
