package com.aoki.test.memoizer.interfaces;

public interface Computable<A,V> {
    V computer(A arg);
}
