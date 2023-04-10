package com.chuwa.learn.singleton;

public class SingletonLazy3 {
    private void SingletonLazy3() {}

    private static class SingletonHolder {
        private static final SingletonLazy3 INSTANCE = new SingletonLazy3();
    }

    public SingletonLazy3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
