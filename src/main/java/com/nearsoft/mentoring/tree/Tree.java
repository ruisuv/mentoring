package com.nearsoft.mentoring.tree;

public interface Tree<T extends Comparable<T>> {

    Node<T> add(T value);
    boolean contains(T value);
    Node<T> delete(T value);
}

