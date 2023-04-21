package com.richard.multithreading.m6_util_concurrent_locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author zhuhaotian
 * @Date 2023/4/19
 * @Description 自己利用CAS实现
 *
 * 增加值并返回新值：int addAndGet(int delta)
 * 加1后返回新值：int incrementAndGet()
 * 获取当前值：int get()
 * 用CAS方式设置：int compareAndSet(int expect, int update)
 */

public class AtomicLearn {

    public int incrementAndGet(AtomicInteger var) {
        /**
         * CAS是指，在这个操作中，如果AtomicInteger的当前值是prev，那么就更新为next，返回true。
         * 如果AtomicInteger的当前值不是prev，就什么也不干，返回false。
         * 通过CAS操作并配合do ... while循环，
         * 即使其他线程修改了AtomicInteger的值，最终的结果也是正确的。
         */
        int prev, next;

        do {
            prev = var.get();
            next = prev + 1;
        } while (!var.compareAndSet(next, prev));

        return next;
    }
}

/**
 * @Description 直接使用现有的
 */
class IdGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextId() {
        return var.incrementAndGet();
    }
}
