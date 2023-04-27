package Create;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    public String call() throws Exception {
//
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        return "0";

    }
}
