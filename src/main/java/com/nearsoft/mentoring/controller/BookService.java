package com.nearsoft.mentoring.controller;


import com.nearsoft.mentoring.model.Book;
import com.nearsoft.mentoring.tree.Tree;

public interface BookService {

    Tree<Book> add(Book value);
    Tree<Book> getAll();


}
