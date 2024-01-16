package com.unitral.graphql;

import com.unitral.graphql.models.Book;
import com.unitral.graphql.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphQlApplication implements CommandLineRunner {
    @Autowired
    private Service bookService=null;
    public static void main(String[] args) {


        SpringApplication.run(GraphQlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        bookService.insertBook(new Book(0, "Physics", "Rv", 53.5F, "B.Tech2"));
        bookService.insertBook(new Book(0, "Chemistry", "AS", 53.9F, "B.Tech3"));

    }
}
