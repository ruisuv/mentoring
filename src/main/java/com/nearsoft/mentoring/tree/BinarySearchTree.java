package com.nearsoft.mentoring.tree;

import lombok.Getter;
import lombok.ToString;

@ToString
public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    @Getter
    private Node<T> root;

    public void add(T value) {
        root = add(root, value);
    }

    private boolean isBalanced(Node<T> node) {
        return Math.abs(getHeight(node.getLeft()) - getHeight(node.getRight())) <= 1;
    }

    private Node<T> add(Node<T> current, T value) {
        if (current == null) {
            current = new Node<>(value);
        }
        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(add(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(add(current.getRight(), value));
        }

        return current;
    }

    private int getHeight(Node<T> node) {
        if (node == null) {
            return 0;
        }
        Node<T> leftNode = node.getLeft();
        int leftHeight = leftNode == null ? 1 : 1 + getHeight(leftNode);
        Node<T> rightNode = node.getRight();
        int rightHeight = rightNode == null ? 1 : 1 + getHeight(rightNode);
        return Math.max(leftHeight, rightHeight);
    }


    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (value.compareTo(current.getValue()) < 0) {
            return contains(current.getLeft(), value);
        } else if (value.compareTo(current.getValue()) > 0) {
            return contains(current.getRight(), value);
        } else {
            return true;
        }
    }

    public void delete(T value) {
        delete(root, value);
    }

    private Node<T> delete(Node<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(delete(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(delete(current.getRight(), value));
        } else {

            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            // Get the smallest value from the right side of the node (bigger values)
            T smallestValue = getSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(delete(current.getRight(), smallestValue));

            // Alternatively node's value can be replaced with the biggest from left side.
//            T biggestValue = getBiggestValue(current.getRight());
//            current.setValue(biggestValue);
//            current.setLeft(delete(current.getLeft(), biggestValue));



		}
		return current;
	}

    private T getBiggestValue(Node<T> current) {
        Node<T> right = current.getRight();
        return right == null ? current.getValue() : getBiggestValue(right);
    }

    private T getSmallestValue(Node<T> current) {
        Node<T> left = current.getLeft();
        return left == null ? current.getValue() : getSmallestValue(current.getLeft());
    }

    private StringBuilder transverseInOrder(Node<T> current) {
        if (current == null) {
            return new StringBuilder();
        }
        return new StringBuilder()
                .append(transverseInOrder(current.getLeft()))
                .append(" ")
                .append(current.getValue())
                .append(transverseInOrder(current.getRight()));
    }

    private StringBuilder transversePreOrder(Node<T> current, int level) {
        StringBuilder indentation = new StringBuilder();

        for (int i = 0; i < level; i++) {
            indentation.append("\t");
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(current.getValue()).append("]")
                .append("\n").append(indentation).append("|--");
        if (current.getRight() != null) {
            stringBuilder.append(transversePreOrder(current.getRight(), level + 1));
        }
        stringBuilder.append("\n").append(indentation).append("|--");
        if (current.getLeft() != null) {
            stringBuilder.append(transversePreOrder(current.getLeft(), level + 1));
        }


        return stringBuilder;

    }

}
