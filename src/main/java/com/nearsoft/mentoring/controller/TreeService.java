package com.nearsoft.mentoring.controller;


import com.nearsoft.mentoring.tree.Tree;

public interface TreeService<T extends Comparable<T>> {

    Tree<T> add(T value);
    Tree<T> getAll();


}
