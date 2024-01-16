package com.unitral.graphql.service.impl;

import com.unitral.graphql.models.Book;
import com.unitral.graphql.repository.BookRepository;
import com.unitral.graphql.service.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements  Service{

   private  BookRepository bookRepository=null;

    @Autowired
    public ServiceImp(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    @Override
    public Book insertBook(Book book) {
        Book b=bookRepository.save(book);
        System.out.println(b.getBookId());
        return b;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.findById(id).orElseThrow();
    }
}
