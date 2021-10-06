package com.nearsoft.mentoring.tree;


import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
class Node<T> {

	@NonNull
    private T value;
    private Node<T> left;
    private Node<T> right;


}
