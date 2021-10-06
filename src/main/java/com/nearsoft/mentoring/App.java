package com.nearsoft.mentoring;

import java.sql.SQLOutput;

import com.nearsoft.mentoring.tree.BinarySearchTree;
import com.nearsoft.mentoring.tree.Tree;

public class App {

    public static void main(String[] args) {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);

    }
}
