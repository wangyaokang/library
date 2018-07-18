package com.wyk.framework.service;

public interface Function<T, E> {
    public T callback(E e);
}
