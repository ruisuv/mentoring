package com.nearsoft.mentoring.controller;


import com.nearsoft.mentoring.model.Book;
import com.nearsoft.mentoring.tree.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Tree<Book>> getAll() {
        Tree<Book> response = service.getAll();
        return response != null ? new ResponseEntity<>(response, OK) : new ResponseEntity<>(NOT_FOUND);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> add(@RequestBody Book book) {
        service.add(book);
        return ResponseEntity.created(URI.create(book.getIsbn()))
                .body(book);
    }



}
