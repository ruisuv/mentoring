package com.nearsoft.mentoring.tree;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BinarySearchTreeIntegerTest {

    @Test
    public void testTreeAdd() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.add(5);
        tree.add(6);
        tree.add(4);
        tree.add(5);
        tree.add(3);
        tree.add(4);
        tree.add(7);

        assertThat(tree.contains(10)).isFalse();
        assertThat(tree.contains(7)).isTrue();
        assertThat(tree.contains(6)).isTrue();
        assertThat(tree.contains(5)).isTrue();
        assertThat(tree.contains(4)).isTrue();
        assertThat(tree.contains(3)).isTrue();

        assertThat(tree.toString()).isEqualTo("3 4 5 6 7");


    }

    @Test
    void testDeleteLeaf() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.add(7);
        tree.add(6);
        tree.add(8);

        assertThat(tree.contains(7)).isTrue();
        assertThat(tree.contains(6)).isTrue();
        assertThat(tree.contains(8)).isTrue();

        tree.delete(6);
        assertThat(tree.contains(7)).isTrue();
        assertThat(tree.contains(8)).isTrue();
        assertThat(tree.contains(6)).isFalse();

        tree.delete(8);
        assertThat(tree.contains(7)).isTrue();
        assertThat(tree.contains(8)).isFalse();
        assertThat(tree.contains(6)).isFalse();



    }

    @Test
    void testDeleteOneChild() {
        Tree<Integer> tree = new BinarySearchTree<>();
        //root
        tree.add(7);

        //left
        tree.add(5);
        tree.add(4);
        tree.add(6);

        //right
        tree.add(9);
        tree.add(8);
        tree.add(10);

        assertThat(tree.toString()).isEqualTo("4 5 6 7 8 9 10");

        assertThat(tree.contains(6)).isTrue();
        tree.delete(6);
        assertThat(tree.contains(6)).isFalse();
        assertThat(tree.toString()).isEqualTo("4 5 7 8 9 10");

        assertThat(tree.contains(4)).isTrue();
        tree.delete(4);
        assertThat(tree.contains(4)).isFalse();
        assertThat(tree.toString()).isEqualTo("5 7 8 9 10");
    }

    @Test
    void testDeleteTwoChildren() {
        Tree<Integer> tree = new BinarySearchTree<>();
        //root
        tree.add(7);

        //left
        tree.add(5);
        tree.add(4);
        tree.add(6);

        //right
        tree.add(9);
        tree.add(8);
        tree.add(10);

        assertThat(tree.toString()).isEqualTo("4 5 6 7 8 9 10");

        assertThat(tree.contains(9)).isTrue();
        tree.delete(9);
        assertThat(tree.contains(9)).isFalse();
        assertThat(tree.toString()).isEqualTo("4 5 6 7 8 10");

        assertThat(tree.contains(5)).isTrue();
        tree.delete(5);
        assertThat(tree.contains(5)).isFalse();
        assertThat(tree.toString()).isEqualTo("4 6 7 8 10");
    }

    @Test
    void testIsBalancedTree() {
        Tree<Integer> tree = new BinarySearchTree<>();
        //root
        tree.add(7);
        System.out.println(tree);


        //left
        tree.add(5);
        System.out.println(tree);
        tree.add(4);
        System.out.println(tree);
        tree.add(8);
        System.out.println(tree);
        tree.add(6);
        System.out.println(tree);
    }
}