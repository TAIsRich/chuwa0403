package com.richard.homework_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class SumAndProduct {

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>() {{
            add(Arrays.asList(1, 2));
            add(Arrays.asList(3, 4));
            add(Arrays.asList(5, 6));
            add(Arrays.asList(7, 8));
        }};

        ExecutorService es = Executors.newCachedThreadPool();

        for (List<Integer> list : lists) {
            CompletableFuture<String> future = CompletableFuture
                    .supplyAsync(() -> SumAndProductUtil.sum(list.get(0), list.get(1)), es)
                    .thenCombine(
                            CompletableFuture.supplyAsync(() -> SumAndProductUtil.product(list.get(0), list.get(1)), es),
                            (s1, s2) -> s1 + " " + s2
                    );

            try {
                System.out.println(Thread.currentThread().getName() + ": " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        es.shutdown();
    }
}
