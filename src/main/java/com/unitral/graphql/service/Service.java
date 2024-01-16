package com.unitral.graphql.service;

import com.unitral.graphql.models.Book;

import java.util.List;

public interface Service {

    public Book insertBook(Book book);
    public List<Book> getAllBooks();

    public Book getBook(int id);
}
