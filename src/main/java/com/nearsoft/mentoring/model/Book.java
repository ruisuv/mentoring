package com.nearsoft.mentoring.model;

import lombok.Data;

import java.util.Comparator;

@Data
public class Book implements Comparable<Book>{

    private final String title;
    private final String author;
    private final String isbn;
    private final int year;

    @Override
    public int compareTo(Book o) {
        return Comparator.comparing(Book::getTitle)
                .thenComparing(Book::getAuthor)
                .thenComparing(Book::getYear)
                .thenComparing(Book::getIsbn)
                .compare(this, o);
    }
}
