package com.nearsoft.mentoring.tree;

import java.util.List;

public interface Tree<T extends Comparable<T>> {

    void add(T value);
    boolean contains(T value);
    void delete(T value);
    List<T> asList();
}

