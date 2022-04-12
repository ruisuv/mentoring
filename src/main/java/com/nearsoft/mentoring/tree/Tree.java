package com.nearsoft.mentoring.tree;

public interface Tree<T extends Comparable<T>> {

    void add(T value);
    boolean contains(T value);
    void delete(T value);
}

