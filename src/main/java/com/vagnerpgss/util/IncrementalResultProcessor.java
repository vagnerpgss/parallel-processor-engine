package com.vagnerpgss.util;

public interface IncrementalResultProcessor<T> {
    public void add(T o);
    public void finish();
}