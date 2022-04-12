package com.nearsoft.mentoring.tree;


import lombok.Data;
import lombok.NonNull;

@Data
class Node<T> {

	@NonNull
    private T value;
    private Node<T> left;
    private Node<T> right;


}
