package com.richard.multithreading.m9_fork_join;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author zhuhaotian
 * @Date 2023/4/21
 */

public class ForkJoinLearn {

    @Test
    public void demo01() {
        ForkJoinTask task = new ForkJoinTask(1, 10000);
        ForkJoinPool pool = new ForkJoinPool();
        Future<Integer> future = pool.submit(task);

        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class ForkJoinTask extends RecursiveTask<Integer> {

    private final int threshold = 5;
    private int first, last;

    public ForkJoinTask(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        int result = 0;

        if (last - first <= threshold) {
            // small task, just calculate the result directly.
            for (int i = first; i <= last; i++) {
                result += i;
            }
        } else {
            // divide the big tsak into small ones
            int mid = first + (last - first) / 2;

            ForkJoinTask leftTask = new ForkJoinTask(first, mid);
            ForkJoinTask rightTask = new ForkJoinTask(mid + 1, last);

            leftTask.fork();
            rightTask.fork();

            result = leftTask.join() + rightTask.join();
        }

        return result;
    }
}