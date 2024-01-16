package com.unitral.graphql.controler;


import com.unitral.graphql.models.Book;
import com.unitral.graphql.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private  Service  bookService=null;
    @Autowired
    public HomeController(Service bookService){
        this.bookService=bookService;

    }

    @PostMapping("/")
    public ResponseEntity<Book> addBook(@RequestBody  Book book){
        if(book==null){
            return new ResponseEntity<>(null, HttpStatusCode.valueOf(501));
        }

        return new ResponseEntity<>(bookService.insertBook(book), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBooks(@PathVariable("id") int id){
        return new ResponseEntity<>(bookService.getBook(id), HttpStatusCode.valueOf(200));
    }



}
